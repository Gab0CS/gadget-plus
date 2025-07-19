package com.gabo.gadget_plus.repositories;

import org.springframework.data.repository.CrudRepository;

import com.gabo.gadget_plus.entities.BillEntity;

public interface BillRepository extends CrudRepository<BillEntity, String> {

}
