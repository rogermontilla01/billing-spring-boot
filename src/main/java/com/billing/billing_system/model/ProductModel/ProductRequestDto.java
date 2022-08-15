package com.billing.billing_system.model.ProductModel;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Validated
public class ProductRequestDto {
    @NotNull(message = "productName is required")
    @NotBlank(message = "productName can't be empty")
    private String productName;

    @NotNull(message = "quantity is required")
    private Integer quantity;

    @NotNull(message = "price is required")
    private BigDecimal price;

    @NotNull(message = "description is required")
    @NotBlank(message = "description can't be empty")
    private String description;

    @NotNull(message = "code is required")
    private Integer code;
}
