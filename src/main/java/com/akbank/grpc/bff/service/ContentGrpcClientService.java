package com.akbank.grpc.bff.service;

import com.akbank.model.ContentServiceGrpc;
import com.akbank.model.HiRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ContentGrpcClientService {

    @GrpcClient("content-service")
    private ContentServiceGrpc.ContentServiceBlockingStub blockingStub;

    public String sayHi(String message){
        return this.blockingStub.sayHi(HiRequest.newBuilder().
                setMessage(message).build()).
                getResult();
    }
}
