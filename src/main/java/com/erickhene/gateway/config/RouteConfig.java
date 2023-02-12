package com.erickhene.gateway.config;

import com.erickhene.gateway.entity.impl.Route;
import com.erickhene.gateway.filter.CustomFilter;
import com.erickhene.gateway.service.impl.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class RouteConfig {
    private final RouteService routeService;

    public RouteConfig(RouteService routeService) {
        this.routeService = routeService;
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        Optional<List<Route>> allRoute = routeService.getAllRoute();
        log.info("Route Present {}", allRoute.isPresent());
        if (allRoute.isPresent()){
            for (Route route: allRoute.get()) {
                routes.route(r -> r
                        .path(route.getPath())
                        .filters(f -> {
                            log.info("Set {}", route.getPath());
                            CustomFilter customFilter = new CustomFilter(keycloakAuth);
                            return f.filter(customFilter);
                        })
                        .uri(route.getUri()));
            }
        }
        return routes.build();
    }
}
