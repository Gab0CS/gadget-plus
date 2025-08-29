package com.gabo.gadget_plus.controllers;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportProduct {
    private String brandName;
    private Double averagePrice;
    private BigDecimal sumPrices;
}
