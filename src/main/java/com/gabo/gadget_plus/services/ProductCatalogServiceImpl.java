package com.gabo.gadget_plus.services;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabo.gadget_plus.controllers.ReportProduct;
import com.gabo.gadget_plus.entities.ProductCatalogEntity;
import com.gabo.gadget_plus.enums.DateEval;
import com.gabo.gadget_plus.repositories.ProductCatalogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductCatalogServiceImpl implements ProductCatalogService {

    
    private final ProductCatalogRepository catalogRepository;
    private static final int pageZise = 5;
    private static final int minPageSize = 2;

    @Override
    public ProductCatalogEntity findByld(UUID id) {
        return this.catalogRepository.findById(id).orElseThrow();
    }
    @Override
    public ProductCatalogEntity findByName(String name) { 
        return this.catalogRepository.findByName(name).orElseThrow();
    }
    @Override
    public List<ProductCatalogEntity> findByNameLike(String key) { 
        return this.catalogRepository.findByNameLike(key);
    }
    @Override
    public List <ProductCatalogEntity> findNameBetween(BigDecimal min, BigDecimal max) { 
        return this.catalogRepository.findBetweenTwoPrices(min, max);
    }
    @Override
    public List <ProductCatalogEntity> findByCategoryId(Long id) {
        return this.catalogRepository.getByCategory(id);
    }

    @Override
    public List<ProductCatalogEntity> findByLaunchingDate(LocalDate date, DateEval key) {
        if(key.equals(DateEval.getKey("AFTER"))){
            return this.catalogRepository.findByLaunchingDateAfter(date);
        } else {
            return this.catalogRepository.findByLaunchingDateBefore(date);
        }
    }

    @Override
    public List <ProductCatalogEntity> findByBrandAndRatingGreaterThan(String brand, Short rating) { 
        return this.catalogRepository.findByBrandAndRatingGreaterThan(brand, rating);   
    }

    @Override
    public List <ProductCatalogEntity> findByBrandOrRatingGreaterThan(String brand, Short rating) { 
        return this.catalogRepository.findByBrandOrRatingGreaterThan(brand, rating);   
    }
    @Override
    public Page<ProductCatalogEntity> findAll(String field, Boolean desc, Integer page) { 
         var sorting = Sort.by("name");

        if(Objects.nonNull(field)){
            switch (field) {
                case "brand" -> sorting = Sort.by("brand");
                case "price" -> sorting = Sort.by("price");
                case "launchingDate" -> sorting = Sort.by("launchingDate");
                case "rating" -> sorting = Sort.by("rating");

                default -> throw new IllegalArgumentException("Invalid Field " + field);     
            }
        } 
        System.out.println("Sorting var: " + sorting);
        return (desc) ?
            this.catalogRepository.findAll(PageRequest.of(page, pageZise, sorting.descending()))
            :
            this.catalogRepository.findAll(PageRequest.of(page, pageZise, sorting.ascending())); 
    }
    @Override
    public Page<ProductCatalogEntity> findAllByBrand(String brand, Integer page) { 
        return this.catalogRepository.findAllByBrand(brand, PageRequest.of(page, minPageSize));
    }
    @Override
    public Integer countByBrand(String brand) { 
        return this.catalogRepository.countTotalProductsByBrandStoreProcedure(brand);
    }
    @Override
    public List<ReportProduct> makeReport() {
        return this.catalogRepository.findAndMakeReport();
    }
    
}
