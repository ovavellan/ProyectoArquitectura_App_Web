package com.example.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {


    @Bean
    public RouteLocator productServiceRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("aeropuertos-service", r -> r.path("/aeropuertos/**")
                        .filters(f -> f.rewritePath("/aeropuertos/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8080")
                )
                .route("aviones-service", r -> r.path("/aviones/**")
                        .filters(f -> f.rewritePath("/aviones/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8080")
                )
                .route("pilotos-service", r -> r.path("/pilotos/**")
                        .filters(f -> f.rewritePath("/pilotos/(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8080")
                )
                .route("vuelos-service", r -> r.path("/vuelos//**")
                        .filters(f -> f.rewritePath("/vuelos//(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8090")
                )
                .route("tipo_vuelos-service", r -> r.path("/tipo_vuelos//**")
                        .filters(f -> f.rewritePath("/tipo_vuelos//(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8090")
                )
                .route("mecanico-service", r -> r.path("/mecanicos/**")
                        .filters(f -> f.rewritePath("/vuelos//(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8095")
                )
                .route("mantenimiento-service", r -> r.path("/mantenimiento/**")
                        .filters(f -> f.rewritePath("/tipo_vuelos//(?<segment>.*)", "/${segment}"))
                        .uri("http://localhost:8095")
                )
                .build();
    }
}
