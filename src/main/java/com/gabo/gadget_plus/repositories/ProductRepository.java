package com.gabo.gadget_plus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabo.gadget_plus.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

} 