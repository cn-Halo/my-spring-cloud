package org.os;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author yzm
 * @date 2021/1/25 10:03 上午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker //告诉spring cloud将要使用hystrix
@EnableResourceServer
public class OrganizationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganizationServiceApplication.class, args);
    }
}
