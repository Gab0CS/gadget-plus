package com.gabo.gadget_plus.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "productCatalog")
@Table(name="products_catalog", indexes = {
    @Index(name = "idx_product_name", columnList = "product_name")
})
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCatalogEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "product_name", length = 64)
    private String name;
    @Column(name = "brand_name", length = 64)
    private String brand;
    private String description;
    private BigDecimal price;
    private LocalDate launchingDate;
    private boolean isDiscount;
    private Short rating;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
        CascadeType.DETACH,
        CascadeType.PERSIST,
        CascadeType.REFRESH})
    @JoinTable(
        name = "product_join_category",
        joinColumns = @JoinColumn(name = "id_product"),
        inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private List<CategoryEntity> categories = new LinkedList<>();

    public void addCategory(CategoryEntity categoryEntity){
        this.categories.add(categoryEntity);
    }
}
