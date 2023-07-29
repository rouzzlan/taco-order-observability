package com.falcontech.tacoorder.repo;

import com.falcontech.tacoorder.model.mongo.OrderR;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRRepo extends ReactiveMongoRepository<OrderR, String> {}
