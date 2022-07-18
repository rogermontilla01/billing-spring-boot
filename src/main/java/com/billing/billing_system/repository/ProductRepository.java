package com.billing.billing_system.repository;

import com.billing.billing_system.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findOneById(Long id);

    ProductEntity findOneByCode(Integer code);

    ProductEntity findByProductName(String productName);

    void deleteById(Long id);
}
