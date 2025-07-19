package com.gabo.gadget_plus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabo.gadget_plus.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    
}
