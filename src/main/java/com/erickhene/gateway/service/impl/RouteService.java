package com.erickhene.gateway.service.impl;

import com.erickhene.gateway.entity.impl.Route;
import com.erickhene.gateway.service.Base;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService implements Base {
    @Override
    public Optional<List<Route>> getAllRoute() {
        return Optional.empty();
    }
}
