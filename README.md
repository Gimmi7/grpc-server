# grpc-server

## server deadline
***

* 获取客户端的Context
    * `public final class ServerImpl extends Server implements InternalInstrumented<ServerStats> {}`
* 在ServerImpl的构造函数中有如下代码
    * `this.rootContext = ((Context)Preconditions.checkNotNull(rootContext, "rootContext")).fork();`
* server端创造context
```java
 private CancellableContext createContext(final ServerStream stream, Metadata headers, StatsTraceContext statsTraceCtx) {
            Long timeoutNanos = (Long)headers.get(GrpcUtil.TIMEOUT_KEY);
            Context baseContext = statsTraceCtx.serverFilterContext(ServerImpl.this.rootContext);
            if (timeoutNanos == null) {
                return baseContext.withCancellation();
            } else {
                CancellableContext context = baseContext.withDeadlineAfter(timeoutNanos, TimeUnit.NANOSECONDS, this.transport.getScheduledExecutorService());

                final class ServerStreamCancellationListener implements CancellationListener {
                    ServerStreamCancellationListener() {
                    }

                    public void cancelled(Context context) {
                        Status status = Contexts.statusFromCancelled(context);
                        if (Status.DEADLINE_EXCEEDED.getCode().equals(status.getCode())) {
                            stream.cancel(status);
                        }

                    }
                }

                context.addListener(new ServerStreamCancellationListener(), MoreExecutors.directExecutor());
                return context;
            }
        }
```
* Listener的代码
```java
  private class ExecutableListener implements Runnable {
        private final Executor executor;
        private final Context.CancellationListener listener;

        private ExecutableListener(Executor executor, Context.CancellationListener listener) {
            this.executor = executor;
            this.listener = listener;
        }

        private void deliver() {
            try {
                this.executor.execute(this);
            } catch (Throwable var2) {
                Context.log.log(Level.INFO, "Exception notifying context listener", var2);
            }

        }

        public void run() {
            this.listener.cancelled(Context.this);
        }
    }
    private final class ContextCancellationListener implements CancellationListener {
            private ContextCancellationListener() {
            }
    
            public void cancelled(Context context) {
                ClientCallImpl.this.stream.cancel(Contexts.statusFromCancelled(context));
            }
        }
```

***
## canceld exception
```java
private static final class ServerCallStreamObserverImpl<ReqT, RespT> extends ServerCallStreamObserver<RespT>{
    public void onNext(RespT response) {
                if (this.cancelled) {
                    if (this.onCancelHandler == null) {
                        throw Status.CANCELLED.withDescription("call already cancelled").asRuntimeException();
                    }
                } else {
                    if (!this.sentHeaders) {
                        this.call.sendHeaders(new Metadata());
                        this.sentHeaders = true;
                    }
    
                    this.call.sendMessage(response);
                }
            }
}

 public StatusRuntimeException asRuntimeException() {
        return new StatusRuntimeException(this);
    }
    
public class StatusRuntimeException extends RuntimeException{}    

```
## 服务端处理deadline

`Context.current()`可以获取当前线程的Context.
然后可以使用2中方法来处理deadline
* `Context.current().isCanceled()`,通过判断响应流是否已经因为过期而被取消,
然后执行处理代码。缺点就是可能在你判断的时候没有被取消，不过在你执行处理代码过程中被取消了。
* `Context.current().getDeadline()`这里返回的deadline是客户端deadline+传输时间；
可以通过取得deadline，自己写一个计时器，来处理执行代码。不过这里有两个问题。<br>
    * 服务端流情况下，deadline只能获取一次，并发怎么做。
    * 计时器和处理代码同步执行且能即时感知到对方，怎么设计。

## pending problem
1.父线程已经抛出运行时异常，子线程再抛出的运行时异常会被捕获。
jvm如何处理runtime exception,多线程情况下的runtime exception.这个问题告诉我们，
不能通过通过触发runtime Exception去停止业务代码，因为在多线程情况下，有可能无法停止。