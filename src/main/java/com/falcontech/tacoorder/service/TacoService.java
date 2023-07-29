package com.falcontech.tacoorder.service;

import com.falcontech.tacoorder.model.dto.OrderR;
import com.falcontech.tacoorder.repo.AddressRepo;
import com.falcontech.tacoorder.repo.OrderRRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TacoService {
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

  public Mono<OrderR> findByID(String id) {
    return orderRRepo.findById(id).flatMap(order -> {
      return addressRepo.findById(order.getAddress()).flatMap(address -> {
        var dto = order.toDTO();
        dto.setAddress(address.toDTO());
        return Mono.just(dto);
      });
    });
  }

  public Mono<com.falcontech.tacoorder.model.mongo.OrderR> persistOrder(com.falcontech.tacoorder.model.dto.OrderR orderDto) {
    var order = orderDto;
    return Mono.just(order)
        .flatMap(
            order1 ->
                addressService
                    .persistAddress(order1.getAddress().toMongoAddress())
                    .flatMap(
                        address -> {
                          var o = order.toMongoOrder();
                          o.setAddress(address.getId());
                          return orderRRepo.save(o);
                        }));
    //        return orderRepo.save(order);
  }
}
