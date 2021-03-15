package org.os.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<String, Object>();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils
                .authorityListToSet(user.getUserAuthentication()
                        .getAuthorities()));
        return userInfo;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
