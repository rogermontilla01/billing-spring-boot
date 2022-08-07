package com.billing.billing_system.model.SaleModel;

import com.billing.billing_system.model.ProductModel.ProductEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateSaleDto {
    public Integer quantity;

    public String description;

    public BigDecimal price;

    public ProductEntity productId;
}
