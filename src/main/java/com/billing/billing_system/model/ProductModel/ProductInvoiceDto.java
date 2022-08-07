package com.billing.billing_system.model.ProductModel;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
public class ProductInvoiceDto {
    @NotNull(message = "quantity is required")
    private Integer quantity;

    @NotNull(message = "code is required")
    private Integer code;
}
