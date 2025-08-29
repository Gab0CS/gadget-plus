package com.gabo.gadget_plus.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabo.gadget_plus.entities.ProductCatalogEntity;
import com.gabo.gadget_plus.enums.DateEval;
import com.gabo.gadget_plus.enums.LikeKey;
import com.gabo.gadget_plus.services.ProductCatalogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "product-catalog")
@RequiredArgsConstructor
public class ProductCatalogController {

    private final ProductCatalogService productCatalogService;

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductCatalogEntity> getById(@PathVariable String id){
        return ResponseEntity.ok(this.productCatalogService.findByld(UUID.fromString(id)));
    }

    @GetMapping(path = "name/{name}")
    public ResponseEntity<ProductCatalogEntity> getByName(@PathVariable String name){
        return ResponseEntity.ok(this.productCatalogService.findByName(name));
    }

    @GetMapping(path = "like/{key}")
    public ResponseEntity<List<ProductCatalogEntity>> getByNameLike(@PathVariable String key, @RequestParam String word){
        final var placeHolder = "%";

        if(key.equals(LikeKey.getKey("AFTER"))){
            return ResponseEntity.ok(this.productCatalogService.findByNameLike(placeHolder + word));
        }

        if(key.equals(LikeKey.getKey("BEFORE"))){
            return ResponseEntity.ok(this.productCatalogService.findByNameLike(word + placeHolder));
        }

        if(key.equals(LikeKey.getKey("BETWEEN"))){
            return ResponseEntity.ok(this.productCatalogService.findByNameLike(placeHolder + word + placeHolder));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(path = "between")
    public ResponseEntity<List<ProductCatalogEntity>> getBetween(@RequestParam BigDecimal min, @RequestParam BigDecimal max){
        return ResponseEntity.ok(this.productCatalogService.findNameBetween(min, max));
    }

    @GetMapping(path = "category")
    public ResponseEntity<List<ProductCatalogEntity>> getByCategoryId(@RequestParam Long id){
        return ResponseEntity.ok(this.productCatalogService.findByCategoryId(id));
    }

    @GetMapping(path = "launch-date/{key}")
    public ResponseEntity<List<ProductCatalogEntity>> getByDate(
        @PathVariable DateEval key, @RequestParam LocalDate date){
            return ResponseEntity.ok(this.productCatalogService.findByLaunchingDate(date, key));
    }

    @GetMapping(path = "brand-rating")
    public ResponseEntity<List<ProductCatalogEntity>> getByBrandAndRating(@RequestParam String brand, @RequestParam Short rating){
            // return ResponseEntity.ok(this.productCatalogService.findByBrandAndRatingGreaterThan(brand, rating));
            return ResponseEntity.ok(this.productCatalogService.findByBrandOrRatingGreaterThan(brand, rating));
    }

    @GetMapping(path = "report")
    public ResponseEntity<List<ReportProduct>> getReport(){
            return ResponseEntity.ok(this.productCatalogService.makeReport());
    }

    @GetMapping(path = "all")
    public ResponseEntity<Page<ProductCatalogEntity>> getAll(
        @RequestParam(required = false) String field,
        @RequestParam(required = true) Boolean desc,
        @RequestParam(required = true) Integer page
    ){
            return ResponseEntity.ok(this.productCatalogService.findAll(field, desc, page));
    }

    @GetMapping(path = "all-by-brand")
    public ResponseEntity<Page<ProductCatalogEntity>> getAllByBrand(
        @RequestParam String brand,
        @RequestParam Integer page
    ){
            return ResponseEntity.ok(this.productCatalogService.findAllByBrand(brand, page));
    }

    @GetMapping(path = "brand-count/{brand}")
    public ResponseEntity<Integer> getCountByBrand(@PathVariable String brand){
            return ResponseEntity.ok(this.productCatalogService.countByBrand(brand));
    }

}
