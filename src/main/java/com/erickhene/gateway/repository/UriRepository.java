package com.erickhene.gateway.repository;

import com.erickhene.gateway.entity.impl.Uri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UriRepository extends JpaRepository<Uri, String> {
    Optional<List<Uri>> findAllByRouteUuid(String routeUuid);
}
