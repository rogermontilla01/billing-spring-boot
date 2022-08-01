package com.billing.billing_system.repository;

import com.billing.billing_system.model.SaleModel.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
    SaleEntity findOneById(Long id);

    void deleteById(Long id);
}
