package com.verve.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBack(){
        return "User service is taking longer than expected, PLease try again";
    }
    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBack(){
        return "User service is taking longer than expected, PLease try again";
    }
}
