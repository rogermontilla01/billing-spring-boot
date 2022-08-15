package com.billing.billing_system.model.SaleModel;

import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.billing.billing_system.model.ProductModel.ProductEntity;
import com.billing.billing_system.model.ProductModel.ProductResponseDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SaleResponseDto {
    private Integer quantity;

    private String description;

    private String productName;

    private Integer productCode;

    private BigDecimal price;

    private Long invoiceId;
}
