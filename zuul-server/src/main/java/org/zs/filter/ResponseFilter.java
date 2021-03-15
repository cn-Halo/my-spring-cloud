package org.zs.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.commmon.dto.UserContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author yzm
 * @date 2021/1/25 4:46 下午
 */
@Component
public class ResponseFilter extends ZuulFilter {

    static final String SERIAL_ID = "serialId";

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();
        response.addHeader(SERIAL_ID, UUID.randomUUID().toString());
//        Thread

        return null;
    }
}
