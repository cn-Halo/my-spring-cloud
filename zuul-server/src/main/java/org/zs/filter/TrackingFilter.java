package org.zs.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author yzm
 * @date 2021/1/25 3:14 下午
 */
@Component
public class TrackingFilter extends ZuulFilter {

    static final String SERIAL_ID = "serialId";


    @Override
    public String filterType() {
        return "pre";
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
        HttpServletRequest request = ctx.getRequest();
        if (request.getHeader(SERIAL_ID) == null) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
            ctx.addZuulRequestHeader(SERIAL_ID, uuid);

        }
        return null;
    }
}
