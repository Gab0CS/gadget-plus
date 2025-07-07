package com.gabo.gadget_plus.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gabo.gadget_plus.entities.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
    
}
