package com.falcontech.tacoorder.repo;

import com.falcontech.tacoorder.model.mongo.Address;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends ReactiveMongoRepository<Address, String> {}
