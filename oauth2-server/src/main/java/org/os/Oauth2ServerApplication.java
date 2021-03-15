package org.os;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer //告诉Spring cloud 这是一个受保护的资源 强制执行一个过滤器，该过滤器会拦截对该服务的所有传入调用，检查传入调用的 HTTP 首部中是否存在 0Auth2 访问 令牌，然后调用 securityoauth2 resource userinfoUri 中定义的回调 URL 来查看令牌是否有效 一旦获悉令牌是有效的，＠EnableResourceServer 注解也会应用任何访问控制规则，以控制什么人可以访问服务
@EnableAuthorizationServer //告诉spring cloud 该服务将作为Oauth2服务
public class Oauth2ServerApplication {


    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerApplication.class, args);
    }

}
