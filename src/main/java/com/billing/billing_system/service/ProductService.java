package com.billing.billing_system.service;

import com.billing.billing_system.model.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity createProduct(ProductEntity product);

    ProductEntity findOneById(Long id);

    List<ProductEntity> findAll();

    ProductEntity findByCode(Integer code);

    ProductEntity findByProductName(String productName);

    void deleteById(Long id);
}
