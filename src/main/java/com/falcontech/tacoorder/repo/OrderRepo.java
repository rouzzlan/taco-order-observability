package com.falcontech.tacoorder.repo;

import com.falcontech.tacoorder.model.mongo.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepo extends ReactiveMongoRepository<Order, String> {}
