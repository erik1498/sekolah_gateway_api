package com.erickhene.gateway.entity.impl;

import com.erickhene.gateway.entity.Base;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "route_tab")
@Entity
@Getter
@Setter
public class Route extends Base {
    @Column(name = "r_path", nullable = false)
    private String path;
    @Column(name = "r_uri", nullable = false)
    private String uri;
}
