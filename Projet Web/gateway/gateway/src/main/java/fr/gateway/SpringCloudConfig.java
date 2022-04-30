package fr.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringCloudConfig {
    @Autowired
    private JwtCustomFilter customJwtFilter;
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/comptes/**")
                        .filters(f ->
                                f.addRequestHeader("header-1", "value1")
                                        .addResponseHeader("header-response-1", "value-response-1")
                        )
                        .uri("lb://comptes"))
                .route(r -> r.path("/produits/**")
                        .uri("lb://produits"))
                .route(r -> r.path("/commandes/**")
                        .uri("lb://commandes"))
                .build();
    }

}

