package com.erickhene.gateway.repository;

import com.erickhene.gateway.entity.impl.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, String> {
}
