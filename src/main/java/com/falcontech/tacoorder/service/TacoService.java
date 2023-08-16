package com.falcontech.tacoorder.service;

import com.falcontech.tacoorder.model.dto.Order;
import com.falcontech.tacoorder.repo.AddressRepo;
import com.falcontech.tacoorder.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TacoService {
  private final AddressRepo addressRepo;
  private final AddressService addressService;
  private final OrderRepo orderRepo;

  public Flux<Order> findAll() {
    return orderRepo
        .findAll()
        .flatMap(
            order ->
                addressRepo
                    .findById(order.getAddress())
                    .flatMap(
                        address -> {
                          var dto = order.toDTO();
                          dto.setAddress(address.toDTO());
                          return Mono.just(dto);
                        }));
  }

  public Mono<Order> findByID(String id) {
    return orderRepo
        .findById(id)
        .flatMap(
            order ->
                addressRepo
                    .findById(order.getAddress())
                    .flatMap(
                        address -> {
                          var dto = order.toDTO();
                          dto.setAddress(address.toDTO());
                          return Mono.just(dto);
                        }));
  }

  public Mono<com.falcontech.tacoorder.model.mongo.Order> persistOrder(Order orderDto) {
      return Mono.just(orderDto)
        .flatMap(
            order1 ->
                addressService
                    .persistAddress(order1.getAddress().toMongoAddress())
                    .flatMap(
                        address -> {
                          var o = orderDto.toMongoOrder();
                          o.setAddress(address.getId());
                          return orderRepo.save(o);
                        }));
  }
}
