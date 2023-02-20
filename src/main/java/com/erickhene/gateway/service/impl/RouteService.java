package com.erickhene.gateway.service.impl;

import com.erickhene.gateway.entity.impl.Route;
import com.erickhene.gateway.repository.RouteRepository;
import com.erickhene.gateway.service.Base;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RouteService implements Base<Route> {
    private final RouteRepository repository;

    public RouteService(RouteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<List<Route>> getAllData() {
        log.info("Begin [{}]", "getAllDataRoute");
        return repository.findAllByEnabledTrue();
    }
}
