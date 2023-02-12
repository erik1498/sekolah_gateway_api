package com.erickhene.gateway.filter;

import com.erickhene.gateway.keycloak.KeycloakAuth;
import com.erickhene.gateway.util.IPAddressUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomFilter implements GatewayFilter {
    private String ipAddress;
    private final KeycloakAuth keycloakAuth;

    public CustomFilter(KeycloakAuth keycloakAuth) {
        this.keycloakAuth = keycloakAuth;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ipAddress = IPAddressUtil.getClientIPAddressReactiveServerHttpRequest(request);
        log.info("IP Address = {}", ipAddress);
        log.info("Request Url = {}", exchange.getRequest().getPath());
        log.info("Authenticate = {}", keycloakAuth.authToken(String.valueOf(request.getHeaders().get("Authorization"))));
        return chain.filter(exchange);
    }

}
