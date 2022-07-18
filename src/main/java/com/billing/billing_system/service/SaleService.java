package com.billing.billing_system.service;

import com.billing.billing_system.model.SaleEntity;

import java.util.List;

public interface SaleService {
    SaleEntity createSale(SaleEntity newSaleEntity);

    SaleEntity findOneById(Long id);

    List<SaleEntity> findAll();

    void deleteById(Long id);
}
