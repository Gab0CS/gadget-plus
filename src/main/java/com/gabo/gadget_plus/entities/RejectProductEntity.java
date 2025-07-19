package com.gabo.gadget_plus.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reject_products")
@IdClass(RejectProductId.class)
public class RejectProductEntity {

    @Id
    private String productName;
    @Id
    private String brandName;
    private Integer quantity;
}
