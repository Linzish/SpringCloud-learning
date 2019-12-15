package me.unc.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

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
    public Object run() throws ZuulException {
//        RequestContext context = RequestContext.getCurrentContext();
//        HttpServletRequest request = context.getRequest();
//
//        logger.info("send {} request {}", request.getMethod(), request.getRequestURL().toString());
//
//        //获取请求参数中的accessToken，如果为空则拒绝访问
//        String accessToken = request.getParameter("accessToken");
//        if (accessToken == null) {
//            logger.warn("access token is empty");
//            context.setSendZuulResponse(false);
//            context.setResponseStatusCode(401);
//            return null;
//        }
//        logger.info("access token ok");
        return null;
    }
}
