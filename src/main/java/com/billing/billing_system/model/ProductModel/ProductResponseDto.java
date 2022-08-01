package com.billing.billing_system.model.ProductModel;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponseDto {
    private String productName;

    private Long quantity;

    private BigDecimal price;

    private String description;

    private Integer code;
}
