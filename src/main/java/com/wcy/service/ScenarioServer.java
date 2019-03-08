package com.wcy.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ScenarioServer {

    @Autowired
    ScenarioService service;

    private Server server;

    public void launchWithPort(int port) throws InterruptedException, IOException {
        server= ServerBuilder.forPort(port).addService(service).build();
        this.start();
        this.blockingUtilShutdown();
    }
    private void start() throws IOException {
        server.start();
        System.out.println("grpc-server is start............");
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.err.println("*******shutting down grpc-server since JVM is shutting downing");
                shutdown();
                System.err.println("****grpc-server shut down");
            }
        });
    }

    public void shutdown(){
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockingUtilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
