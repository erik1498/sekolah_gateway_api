package com.erickhene.gateway.config;

import com.erickhene.gateway.filter.CustomFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RouteConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/get")
                        .filters(f -> {
                            CustomFilter filter = new CustomFilter();
                            return f.filter(filter);
                        })
                        .uri("http://httpbin.org"))
                .build();
    }
}
