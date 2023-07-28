package com.falcontech.tacoorder.service;

import com.falcontech.tacoorder.model.mongo.Order;
import com.falcontech.tacoorder.repo.AddressRepo;
import com.falcontech.tacoorder.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class TacoService {
    private final OrderRepo orderRepo;
    private final AddressRepo addressRepo;

    public Flux<Order> findAll() {
        return orderRepo.findAll();
    }

    public Mono<Order> persistOrder(com.falcontech.tacoorder.model.dto.Order orderDto) {
        var order = orderDto.toMongoOrder();
        return Mono.just(order).flatMap(order1 -> addressRepo.save(order1.getAddress()).flatMap(address -> {
            order1.setAddress(address);
            return orderRepo.save(order1);
        }));
//        return orderRepo.save(order);
    }
}
