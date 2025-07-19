package com.gabo.gadget_plus.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabo.gadget_plus.entities.ProductCatalogEntity;

public interface ProductCatalogRepository extends JpaRepository<ProductCatalogEntity, UUID> {

}
