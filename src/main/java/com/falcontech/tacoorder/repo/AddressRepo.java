package com.falcontech.tacoorder.repo;

import com.falcontech.tacoorder.model.mongo.Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AddressRepo extends ReactiveMongoRepository<Address, String> {
    Mono<Address> findAddressByHash(String hash);
}
