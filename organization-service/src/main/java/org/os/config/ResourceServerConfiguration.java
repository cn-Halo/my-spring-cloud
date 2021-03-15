package org.os.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author yzm
 * @date 2021/2/1 12:27 下午
 */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated();
        http.authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/test2/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated();
    }
}
