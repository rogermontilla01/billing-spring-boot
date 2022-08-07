package com.billing.billing_system.model.SaleModel;

import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.billing.billing_system.model.ProductModel.ProductEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@Validated
public class SaleRequestDto {
    private Integer quantity;

    @NotNull(message = "Description is required")
    @NotBlank(message = "Description can't be empty")
    private String description;

    @NotNull(message = "price is required")
    @NotBlank(message = "price can't be empty")
    private BigDecimal price;

    private ProductEntity productId;
}
