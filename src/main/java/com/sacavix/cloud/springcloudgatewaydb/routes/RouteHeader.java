package com.sacavix.cloud.springcloudgatewaydb.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
import static org.springframework.cloud.gateway.server.mvc.predicate.GatewayRequestPredicates.header;

@Configuration
public class RouteHeader {

    @Bean
    public RouterFunction<ServerResponse> headerRoute() {
        return route("header_route")
                .route(header("X-Foo", "b.r"), http("http://localhost:8081/get"))
                .build();
    }

}
