package com.erickhene.gateway.repository;

import com.erickhene.gateway.entity.impl.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, String> {
    Optional<List<Route>> findAllByEnabledTrue();
}
