package com.erickhene.gateway.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Base<T> {
    Optional<List<T>> getAllData();
}
