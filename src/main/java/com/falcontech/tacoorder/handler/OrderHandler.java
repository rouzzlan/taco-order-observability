package com.falcontech.tacoorder.handler;

import com.falcontech.tacoorder.model.mongo.Order;
import com.falcontech.tacoorder.service.TacoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
public class OrderHandler {
    private final TacoService tacoService;
    public Mono<ServerResponse> getOrder(ServerRequest request) {
        return ok().build();
    }

    public Mono<ServerResponse> getOrders(ServerRequest request) {
        var all = tacoService.findAll();
        return ok().body(all, Order.class);
    }

    public Mono<ServerResponse> createOrder(ServerRequest request) {
        return ok().build();
    }
}
