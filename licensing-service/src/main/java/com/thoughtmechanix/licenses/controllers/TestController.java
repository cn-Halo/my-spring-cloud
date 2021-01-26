package com.thoughtmechanix.licenses.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Value("${example.property}")
    private String exampleProperty;

    @GetMapping("/test1")
    public String testConfig() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return exampleProperty;
    }
}
