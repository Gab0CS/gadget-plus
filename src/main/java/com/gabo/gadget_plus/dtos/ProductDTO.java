package com.gabo.gadget_plus.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class ProductDTO {
    private Long quantity;
    private String name;
}
