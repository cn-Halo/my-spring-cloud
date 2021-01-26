package org.os.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yzm
 * @date 2021/1/25 10:46 上午
 */
@FeignClient("licensingservice")
public interface LicensingServiceFeignClient {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    String testConfig();


}
