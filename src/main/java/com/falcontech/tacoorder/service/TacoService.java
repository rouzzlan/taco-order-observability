package com.falcontech.tacoorder.service;

import com.falcontech.tacoorder.model.dto.OrderR;
import com.falcontech.tacoorder.model.mongo.Order;
import com.falcontech.tacoorder.repo.AddressRepo;
import com.falcontech.tacoorder.repo.OrderRRepo;
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
  private final AddressService addressService;
  private final OrderRRepo orderRRepo;

  public Flux<OrderR> findAll() {
    return orderRRepo.findAll().flatMap(order -> {
      return addressRepo.findById(order.getAddress()).flatMap(address -> {
        var dto = order.toDTO();
        dto.setAddress(address.toDTO());
        return Mono.just(dto);
      });
    });
  }

//  public Mono<OrderR> findByID(String id) {
//    return orderRepo.findById(id).flatMap(order -> {
//      return addressRepo.findById(order.getAddress().getId()).flatMap(address -> {
//        order.setAddress(address);
//        return Mono.just(order.toDTO());
//      });
//    });
//  }

  public Mono<OrderR> findByID(String id) {
    return orderRRepo.findById(id).flatMap(order -> {
      return addressRepo.findById(order.getAddress()).flatMap(address -> {
        var dto = order.toDTO();
        dto.setAddress(address.toDTO());
        return Mono.just(dto);
      });
    });
  }

  public Mono<Order> persistOrder(com.falcontech.tacoorder.model.dto.Order orderDto) {
    var order = orderDto.toMongoOrder();
    return Mono.just(order)
        .flatMap(
            order1 ->
                addressService
                    .persistAddress(order1.getAddress())
                    .flatMap(
                        address -> {
                          order1.setAddress(address);
                          return orderRepo.save(order1);
                        }));
    //        return orderRepo.save(order);
  }
}
