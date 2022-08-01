package com.billing.billing_system.builder;

import com.billing.billing_system.model.ProductModel.ProductEntity;
import com.billing.billing_system.model.ProductModel.ProductRequestDto;
import com.billing.billing_system.model.ProductModel.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductBuilder extends EntityTransform<ProductResponseDto, ProductRequestDto, ProductEntity>{

    @Override
    public ProductResponseDto entityToResponse(ProductEntity product) {
        if(Objects.isNull(product)) return null;

        return ProductResponseDto.builder()
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .description(product.getDescription())
                .code(product.getCode())
                .build();
    }

    @Override
    public ProductEntity requestToEntity(ProductRequestDto product) {
        if(Objects.isNull(product)) return null;

        return ProductEntity.builder()
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .description(product.getDescription())
                .code(product.getCode())
                .build();
    }
}
