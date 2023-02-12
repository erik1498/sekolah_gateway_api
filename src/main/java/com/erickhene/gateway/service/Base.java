package com.erickhene.gateway.service;

import com.erickhene.gateway.entity.impl.Route;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Base {
    Optional<List<Route>> getAllRoute();
}
