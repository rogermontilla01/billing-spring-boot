package com.billing.billing_system.model.SaleModel;

import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.billing.billing_system.model.ProductModel.ProductEntity;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Validated
public class SaleRequestDto {
    private Integer quantity;

    @NotNull(message = "productName is required")
    @NotBlank(message = "productName can't be empty")
    private String Description;

    private BigDecimal price;

    private InvoiceEntity invoiceId;

    private ProductEntity productId;
}
