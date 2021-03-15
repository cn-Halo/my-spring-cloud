package org.os.filter;

import org.commmon.filter.UserContextFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author yzm
 * @date 2021/1/28 9:45 上午
 */
@Component
public class UserContextFilter1 implements Filter {

//    @Autowired
//    UserContextFilter userContextFilter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String serialId = request.getHeader("serialId");
        System.out.println("--" + serialId);
//        System.out.println(userContextFilter);
        filterChain.doFilter(request, servletResponse);
    }


    @Override
    public void destroy() {

    }
}
