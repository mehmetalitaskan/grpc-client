package com.akbank.grpc.bff.controller;

import com.akbank.grpc.bff.service.ContentGrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ContentController {

    @Autowired
    private ContentGrpcClientService grpcClientService;

    @GetMapping("/test")
    public String getMessage(@RequestParam Map<String,String> requestParams){
        if (requestParams.containsKey("hiKey"))
           return grpcClientService.sayHi(requestParams.get("hiKey"));
        return grpcClientService.sayHi("Mali");
    }
}
