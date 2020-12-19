package com.zwx.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author coderZWX
 * @date 2020-12-14 15:32
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_zwx",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"));
        routes.route("path_route_zwx2",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji"));
        return routes.build();
    }

//    @Bean
//    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//
//        routes.route("path_route_zwx2",
//                r -> r.path("/guoji")
//                        .uri("http://news.baidu.com/guoji"));
//        return routes.build();
//    }

}
