package org.os.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.os.remote.LicensingServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yzm
 * @date 2021/1/25 10:10 上午
 */
@RestController
public class TestController {

    @Autowired
    private LicensingServiceFeignClient licensingServiceFeignClient;

    @GetMapping("/test1")
    public String test1() {
        return "Hello World";
    }

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") //断路器的超时时间，默认1s
            }, fallbackMethod = "fallbackMethod",
            threadPoolKey = "testThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")  // 有界阻塞队列 -1代表没有队列
            })
    @GetMapping("/callLicence")
    public String callLicence() {
        return licensingServiceFeignClient.testConfig();
    }

    public String fallbackMethod() {
        System.out.println("fallback");
        return "fallback";
    }

}
