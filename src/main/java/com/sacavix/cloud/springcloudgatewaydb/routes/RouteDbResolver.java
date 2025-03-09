package com.sacavix.cloud.springcloudgatewaydb.routes;

import com.sacavix.cloud.springcloudgatewaydb.persistence.GatewayRoute;
import com.sacavix.cloud.springcloudgatewaydb.persistence.GatewayRouteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;

import java.util.List;

@Service
@Slf4j
public class RouteDbResolver {

    @Autowired
    private GatewayRouteRepository routeRepository;

    @Bean
    public RouterFunction<ServerResponse> routes() {
        RouterFunctions.Builder builder = RouterFunctions.route();

        List<GatewayRoute> routes = routeRepository.findAll();
        for (GatewayRoute r : routes) {
            var routerFunction = route("Route_" + r.getId())
                                        .GET(r.getPath(), http(r.getUri()))
                                        .build();
            log.info("Adding route from database {}", routerFunction);
            builder.add(routerFunction);
        }

        return builder.build();
    }
}