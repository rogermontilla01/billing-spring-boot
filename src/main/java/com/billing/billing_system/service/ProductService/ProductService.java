package com.billing.billing_system.service.ProductService;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ProductModel.ProductRequestDto;
import com.billing.billing_system.model.ProductModel.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto createProduct(ProductRequestDto product) throws ApiException;

    ProductResponseDto findOneById(Long id) throws ApiException;

    List<ProductResponseDto> findAll() throws ApiException;

    ProductResponseDto findByCode(Integer code) throws ApiException;

    ProductResponseDto findByProductName(String productName) throws ApiException;

    void deleteById(Long id) throws ApiException;
}
