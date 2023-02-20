package com.erickhene.gateway.filter;

import com.erickhene.gateway.entity.impl.Uri;
import com.erickhene.gateway.keycloak.KeycloakAuth;
import com.erickhene.gateway.util.IPAddressUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class CustomFilter implements GatewayFilter {
    private final Optional<List<Uri>> uriList;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final KeycloakAuth keycloakAuth = new KeycloakAuth();
        ServerHttpRequest request = exchange.getRequest();
        final String ipAddress = IPAddressUtil.getClientIPAddressReactiveServerHttpRequest(request);
        log.info("IP Address = {}", ipAddress);
        log.info("Request Url = {}", exchange.getRequest().getPath());
        log.info("Authenticate = {}", keycloakAuth.authToken(String.valueOf(request.getHeaders().get("Authorization"))));
        if (uriList.isPresent()){
            for (Uri uri: uriList.get()) {
                if (!uri.getUriPath().equals(exchange.getRequest().getPath().toString())){
                    log.info("Request Uri Not Equal");
                    return chain.filter(exchange);
                }
            }
        }
        return chain.filter(exchange);
    }

}
