package com.billing.billing_system.service;

import com.billing.billing_system.model.SaleEntity;
import com.billing.billing_system.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImp implements SaleService {

    private final SaleRepository saleRepository;

    @Override
    public SaleEntity createSale(SaleEntity newSaleEntity) {
        return saleRepository.save(newSaleEntity);
    }

    @Override
    public SaleEntity findOneById(Long id) {
        return saleRepository.findOneById(id);
    }

    @Override
    public List<SaleEntity> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        saleRepository.deleteById(id);
    }
}
