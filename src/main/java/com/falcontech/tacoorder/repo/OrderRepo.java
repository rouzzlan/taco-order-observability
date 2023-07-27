package com.falcontech.tacoorder.repo;

import com.falcontech.tacoorder.model.mongo.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends ReactiveMongoRepository<Order, String> {}
