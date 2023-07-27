package com.falcontech.tacoorder.controller;

import com.falcontech.tacoorder.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class OrderController {

  private static final String ENDPOINT_PATH = "/order";

  @Bean
  RouterFunction<ServerResponse> orderApis(OrderHandler handler) {
    return route()
        .nest(
            path(ENDPOINT_PATH),
            builder ->
                builder
                    .GET("/{id}", handler::getOrder)
                    .GET("", handler::getOrders)
                    .POST("", handler::createOrder))
        .build();
  }

  @Bean
  CorsWebFilter corsWebFilter() {
    CorsConfiguration config = new CorsConfiguration();
    config.addAllowedOrigin("http://localhost:4200");
    config.addAllowedHeader("*");
    config.setAllowedMethods(List.of(HttpMethod.POST.name(), HttpMethod.GET.name()));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);

    return new CorsWebFilter(source);
  }
}
