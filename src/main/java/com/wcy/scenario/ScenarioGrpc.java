package com.wcy.scenario;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: ScenarioOuter.proto")
public final class ScenarioGrpc {

  private ScenarioGrpc() {}

  public static final String SERVICE_NAME = "com.wcy.scenario.Scenario";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Person,
      Empty> getCheekInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheekIn",
      requestType = Person.class,
      responseType = Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<Person,
      Empty> getCheekInMethod() {
    io.grpc.MethodDescriptor<Person, Empty> getCheekInMethod;
    if ((getCheekInMethod = ScenarioGrpc.getCheekInMethod) == null) {
      synchronized (ScenarioGrpc.class) {
        if ((getCheekInMethod = ScenarioGrpc.getCheekInMethod) == null) {
          ScenarioGrpc.getCheekInMethod = getCheekInMethod = 
              io.grpc.MethodDescriptor.<Person, Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.wcy.scenario.Scenario", "CheekIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Person.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ScenarioMethodDescriptorSupplier("CheekIn"))
                  .build();
          }
        }
     }
     return getCheekInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Empty,
      Chunk> getChunkerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Chunker",
      requestType = Empty.class,
      responseType = Chunk.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Empty,
      Chunk> getChunkerMethod() {
    io.grpc.MethodDescriptor<Empty, Chunk> getChunkerMethod;
    if ((getChunkerMethod = ScenarioGrpc.getChunkerMethod) == null) {
      synchronized (ScenarioGrpc.class) {
        if ((getChunkerMethod = ScenarioGrpc.getChunkerMethod) == null) {
          ScenarioGrpc.getChunkerMethod = getChunkerMethod = 
              io.grpc.MethodDescriptor.<Empty, Chunk>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.wcy.scenario.Scenario", "Chunker"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Chunk.getDefaultInstance()))
                  .setSchemaDescriptor(new ScenarioMethodDescriptorSupplier("Chunker"))
                  .build();
          }
        }
     }
     return getChunkerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CompanyName,
      Company> getGetCompaniesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCompanies",
      requestType = CompanyName.class,
      responseType = Company.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<CompanyName,
      Company> getGetCompaniesMethod() {
    io.grpc.MethodDescriptor<CompanyName, Company> getGetCompaniesMethod;
    if ((getGetCompaniesMethod = ScenarioGrpc.getGetCompaniesMethod) == null) {
      synchronized (ScenarioGrpc.class) {
        if ((getGetCompaniesMethod = ScenarioGrpc.getGetCompaniesMethod) == null) {
          ScenarioGrpc.getGetCompaniesMethod = getGetCompaniesMethod = 
              io.grpc.MethodDescriptor.<CompanyName, Company>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.wcy.scenario.Scenario", "GetCompanies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CompanyName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Company.getDefaultInstance()))
                  .setSchemaDescriptor(new ScenarioMethodDescriptorSupplier("GetCompanies"))
                  .build();
          }
        }
     }
     return getGetCompaniesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Company,
      Empty> getBatchWriteCompaniesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchWriteCompanies",
      requestType = Company.class,
      responseType = Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<Company,
      Empty> getBatchWriteCompaniesMethod() {
    io.grpc.MethodDescriptor<Company, Empty> getBatchWriteCompaniesMethod;
    if ((getBatchWriteCompaniesMethod = ScenarioGrpc.getBatchWriteCompaniesMethod) == null) {
      synchronized (ScenarioGrpc.class) {
        if ((getBatchWriteCompaniesMethod = ScenarioGrpc.getBatchWriteCompaniesMethod) == null) {
          ScenarioGrpc.getBatchWriteCompaniesMethod = getBatchWriteCompaniesMethod = 
              io.grpc.MethodDescriptor.<Company, Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.wcy.scenario.Scenario", "BatchWriteCompanies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Company.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new ScenarioMethodDescriptorSupplier("BatchWriteCompanies"))
                  .build();
          }
        }
     }
     return getBatchWriteCompaniesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Sentence,
      Sentence> getTranslateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Translate",
      requestType = Sentence.class,
      responseType = Sentence.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<Sentence,
      Sentence> getTranslateMethod() {
    io.grpc.MethodDescriptor<Sentence, Sentence> getTranslateMethod;
    if ((getTranslateMethod = ScenarioGrpc.getTranslateMethod) == null) {
      synchronized (ScenarioGrpc.class) {
        if ((getTranslateMethod = ScenarioGrpc.getTranslateMethod) == null) {
          ScenarioGrpc.getTranslateMethod = getTranslateMethod = 
              io.grpc.MethodDescriptor.<Sentence, Sentence>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "com.wcy.scenario.Scenario", "Translate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sentence.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Sentence.getDefaultInstance()))
                  .setSchemaDescriptor(new ScenarioMethodDescriptorSupplier("Translate"))
                  .build();
          }
        }
     }
     return getTranslateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ScenarioStub newStub(io.grpc.Channel channel) {
    return new ScenarioStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScenarioBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ScenarioBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ScenarioFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ScenarioFutureStub(channel);
  }

  /**
   */
  public static abstract class ScenarioImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<Person> cheekIn(
        io.grpc.stub.StreamObserver<Empty> responseObserver) {
      return asyncUnimplementedStreamingCall(getCheekInMethod(), responseObserver);
    }

    /**
     */
    public void chunker(Empty request,
                        io.grpc.stub.StreamObserver<Chunk> responseObserver) {
      asyncUnimplementedUnaryCall(getChunkerMethod(), responseObserver);
    }

    /**
     */
    public void getCompanies(CompanyName request,
                             io.grpc.stub.StreamObserver<Company> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCompaniesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Company> batchWriteCompanies(
        io.grpc.stub.StreamObserver<Empty> responseObserver) {
      return asyncUnimplementedStreamingCall(getBatchWriteCompaniesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Sentence> translate(
        io.grpc.stub.StreamObserver<Sentence> responseObserver) {
      return asyncUnimplementedStreamingCall(getTranslateMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheekInMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                Person,
                Empty>(
                  this, METHODID_CHEEK_IN)))
          .addMethod(
            getChunkerMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                Empty,
                Chunk>(
                  this, METHODID_CHUNKER)))
          .addMethod(
            getGetCompaniesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                CompanyName,
                Company>(
                  this, METHODID_GET_COMPANIES)))
          .addMethod(
            getBatchWriteCompaniesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                Company,
                Empty>(
                  this, METHODID_BATCH_WRITE_COMPANIES)))
          .addMethod(
            getTranslateMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                Sentence,
                Sentence>(
                  this, METHODID_TRANSLATE)))
          .build();
    }
  }

  /**
   */
  public static final class ScenarioStub extends io.grpc.stub.AbstractStub<ScenarioStub> {
    private ScenarioStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScenarioStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ScenarioStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScenarioStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Person> cheekIn(
        io.grpc.stub.StreamObserver<Empty> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCheekInMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void chunker(Empty request,
                        io.grpc.stub.StreamObserver<Chunk> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getChunkerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCompanies(CompanyName request,
                             io.grpc.stub.StreamObserver<Company> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetCompaniesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Company> batchWriteCompanies(
        io.grpc.stub.StreamObserver<Empty> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getBatchWriteCompaniesMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Sentence> translate(
        io.grpc.stub.StreamObserver<Sentence> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTranslateMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ScenarioBlockingStub extends io.grpc.stub.AbstractStub<ScenarioBlockingStub> {
    private ScenarioBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScenarioBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ScenarioBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScenarioBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<Chunk> chunker(
        Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getChunkerMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<Company> getCompanies(
        CompanyName request) {
      return blockingServerStreamingCall(
          getChannel(), getGetCompaniesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ScenarioFutureStub extends io.grpc.stub.AbstractStub<ScenarioFutureStub> {
    private ScenarioFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ScenarioFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ScenarioFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ScenarioFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHUNKER = 0;
  private static final int METHODID_GET_COMPANIES = 1;
  private static final int METHODID_CHEEK_IN = 2;
  private static final int METHODID_BATCH_WRITE_COMPANIES = 3;
  private static final int METHODID_TRANSLATE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ScenarioImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ScenarioImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHUNKER:
          serviceImpl.chunker((Empty) request,
              (io.grpc.stub.StreamObserver<Chunk>) responseObserver);
          break;
        case METHODID_GET_COMPANIES:
          serviceImpl.getCompanies((CompanyName) request,
              (io.grpc.stub.StreamObserver<Company>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHEEK_IN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.cheekIn(
              (io.grpc.stub.StreamObserver<Empty>) responseObserver);
        case METHODID_BATCH_WRITE_COMPANIES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.batchWriteCompanies(
              (io.grpc.stub.StreamObserver<Empty>) responseObserver);
        case METHODID_TRANSLATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.translate(
              (io.grpc.stub.StreamObserver<Sentence>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ScenarioBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScenarioBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.wcy.scenario.ScenarioOuter.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Scenario");
    }
  }

  private static final class ScenarioFileDescriptorSupplier
      extends ScenarioBaseDescriptorSupplier {
    ScenarioFileDescriptorSupplier() {}
  }

  private static final class ScenarioMethodDescriptorSupplier
      extends ScenarioBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ScenarioMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ScenarioGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ScenarioFileDescriptorSupplier())
              .addMethod(getCheekInMethod())
              .addMethod(getChunkerMethod())
              .addMethod(getGetCompaniesMethod())
              .addMethod(getBatchWriteCompaniesMethod())
              .addMethod(getTranslateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
