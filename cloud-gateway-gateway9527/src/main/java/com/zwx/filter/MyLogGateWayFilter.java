package com.zwx.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author coderZWX
 * @date 2020-12-14 18:27
 */
@Component
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    /**
     * 过滤器
     * @param exchange 可以获取request,response等
     * @param chain 过滤器链条
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入过滤器——MyLogGateWayFilter:"+new Date());
        //获取key为uname的请求参数
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname==null){
            System.out.println("用户名为空，非法用户(┬＿┬)");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        System.out.println(uname);
        return chain.filter(exchange);
    }

    /**
     * 过滤器加载的顺序，值越小优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
