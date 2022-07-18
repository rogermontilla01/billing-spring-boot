package com.billing.billing_system.service;

import com.billing.billing_system.model.ProductEntity;
import com.billing.billing_system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public ProductEntity findOneById(Long id) {
        return productRepository.findOneById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity findByCode(Integer code) {
        return productRepository.findOneByCode(code);
    }

    @Override
    public ProductEntity findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
