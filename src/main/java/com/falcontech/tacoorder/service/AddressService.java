package com.falcontech.tacoorder.service;

import com.falcontech.tacoorder.model.mongo.Address;
import com.falcontech.tacoorder.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo addressRepo;

    Mono<Address> persistAddress(@NotNull Address address) {
        return addressRepo.findAddressByHash(address.getHash()).switchIfEmpty(storeAddress(address));
    }

    Mono<Address> storeAddress(@NotNull Address address) {
        return addressRepo.save(address);
    }
}
