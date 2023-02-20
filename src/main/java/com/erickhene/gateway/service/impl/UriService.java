package com.erickhene.gateway.service.impl;

import com.erickhene.gateway.entity.impl.Uri;
import com.erickhene.gateway.repository.UriRepository;
import com.erickhene.gateway.service.Base;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UriService implements Base<Uri> {
    private final UriRepository repository;

    public UriService(UriRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<List<Uri>> getAllData() {
        return Optional.empty();
    }

    public Optional<List<Uri>> getByRouteUuid(String routeUuid) {
        return repository.findAllByRouteUuid(routeUuid);
    }
}
