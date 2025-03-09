package com.sacavix.cloud.springcloudgatewaydb.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GatewayRouteRepository extends JpaRepository<GatewayRoute, Long> {
}