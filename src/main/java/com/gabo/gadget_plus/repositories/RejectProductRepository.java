package com.gabo.gadget_plus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabo.gadget_plus.entities.RejectProductEntity;
import com.gabo.gadget_plus.entities.RejectProductId;

public interface RejectProductRepository extends JpaRepository<RejectProductEntity, RejectProductId> {

}
