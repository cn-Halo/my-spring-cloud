package org.commmon.filter;

import org.commmon.dto.UserContext;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author yzm
 * @date 2021/1/28 11:34 上午
 */
@Component
//@WebFilter(filterName = "UserContextFilter", description = "新增全流程id 并设置到threadLocal中")
//@Order(1)
public class UserContextFilter implements Filter {

    private ThreadLocal<UserContext> threadLocal = new ThreadLocal<UserContext>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String serialId = request.getHeader("serialId");
        System.out.println("--------------------" + serialId);

        UserContext userContext = threadLocal.get();
        if (userContext == null) {
            userContext = new UserContext();
        }
        userContext.setSerialId(serialId);
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
    }


}
