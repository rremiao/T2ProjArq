package com.rremiao.apiGateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class ApiGatewayConfiguration {
     
    @Bean 
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) { 
        return builder.routes() 
                      .route(p -> p.path("/produtos/**") 
                      .uri("lb://produto-service")) 
                      .route(p -> p.path("/vendas/**") 
                      .uri("lb://venda-service")) 
                      .route(p -> p.path("/estoque/**") 
                      .uri("lb://estoque-service"))
                      .route(p -> p.path("/historico/**")
                      .uri("lb://venda-service"))
                      .route(p -> p.path("/integrador/**")
                      .uri("lb://integrador")).build(); 
    } 
}