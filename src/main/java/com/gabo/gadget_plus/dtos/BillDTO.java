package com.gabo.gadget_plus.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {
    private String id;
    private String rfc;
    private BigDecimal amount;
    @JsonIgnore
    private OrderDTO order;
}
