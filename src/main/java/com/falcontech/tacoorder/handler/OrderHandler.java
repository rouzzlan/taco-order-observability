package com.falcontech.tacoorder.handler;

import com.falcontech.tacoorder.model.dto.OrderR;
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
    var id = request.pathVariable("id");
    var order = tacoService.findByID(id);
    return ok().body(order, OrderR.class);
  }

  public Mono<ServerResponse> getOrders(ServerRequest request) {
    var all = tacoService.findAll();
    return ok().body(all, Order.class);
  }

  public Mono<ServerResponse> createOrder(ServerRequest request) {
    return request
        .bodyToMono(com.falcontech.tacoorder.model.dto.OrderR.class)
        .flatMap(tacoService::persistOrder)
        .flatMap(c -> ok().body(Mono.just(c), Order.class));
  }
}
