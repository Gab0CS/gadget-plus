package com.gabo.gadget_plus.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.gabo.gadget_plus.controllers.ReportProduct;
import com.gabo.gadget_plus.entities.ProductCatalogEntity;
import java.time.LocalDate;



public interface ProductCatalogRepository extends JpaRepository<ProductCatalogEntity, UUID> {

    Optional<ProductCatalogEntity> findByName(String name);
    
    List<ProductCatalogEntity> findByNameLike(String key);

    @Query("from productCatalog p where p.price between :min and :max")
    List <ProductCatalogEntity> findBetweenTwoPrices(BigDecimal min, BigDecimal max);

    @Query("from productCatalog p left join fetch p.categories c where c.id = :categoryId")
    List<ProductCatalogEntity> getByCategory(Long categoryId);

    List<ProductCatalogEntity> findByLaunchingDateBefore(LocalDate date);

    List<ProductCatalogEntity> findByLaunchingDateAfter(LocalDate date);

    List<ProductCatalogEntity> findByBrandAndRatingGreaterThan(String brand, Short rating);

    List<ProductCatalogEntity> findByBrandOrRatingGreaterThan(String brand, Short rating);

    @Query("SELECT NEW com.gabo.gadget_plus.controllers.ReportProduct("
            + "pc.brand,"
            + "avg(pc.price),"
            + "sum(pc.price))"
            + "FROM productCatalog pc GROUP BY pc.brand")
    List<ReportProduct> findAndMakeReport();

    Page<ProductCatalogEntity> findAllByBrand(String brand, Pageable page);

    @Procedure(procedureName = "count_total_products_by_brand", outputParameterName = "response")
    Integer countTotalProductsByBrandStoreProcedure(@Param(value = "brand") String brand);
}
