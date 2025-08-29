package com.gabo.gadget_plus.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.gabo.gadget_plus.controllers.ReportProduct;
import com.gabo.gadget_plus.entities.ProductCatalogEntity;
import com.gabo.gadget_plus.enums.DateEval;

public interface ProductCatalogService {
    ProductCatalogEntity findByld(UUID id);
    ProductCatalogEntity findByName(String name);
    List<ProductCatalogEntity> findByNameLike(String key);
    List<ProductCatalogEntity> findNameBetween(BigDecimal min, BigDecimal max);
    List <ProductCatalogEntity> findByCategoryId(Long id);
    List<ProductCatalogEntity> findByLaunchingDate(LocalDate date, DateEval key);
    List <ProductCatalogEntity> findByBrandAndRatingGreaterThan(String brand, Short rating);
    List <ProductCatalogEntity> findByBrandOrRatingGreaterThan(String brand, Short rating);
    List<ReportProduct> makeReport();


    Page<ProductCatalogEntity> findAll(String field, Boolean desc, Integer page);
    Page<ProductCatalogEntity> findAllByBrand(String brand, Integer page);
    
    Integer countByBrand(String brand);

}
