package com.falcontech.tacoorder.service;

import com.falcontech.tacoorder.model.mongo.Order;
import com.falcontech.tacoorder.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@RequiredArgsConstructor
public class TacoService {
    private final OrderRepo orderRepo;

    public Flux<Order> findAll() {
        return orderRepo.findAll();
    }
}
