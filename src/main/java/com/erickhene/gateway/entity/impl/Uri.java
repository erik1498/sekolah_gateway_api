package com.erickhene.gateway.entity.impl;

import com.erickhene.gateway.entity.Base;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "uri_tab")
@Setter
@Getter
public class Uri extends Base {
    @Column(name = "route_uuid")
    private String routeUuid;
    @Column(name = "uri_path")
    private String uriPath;
}
