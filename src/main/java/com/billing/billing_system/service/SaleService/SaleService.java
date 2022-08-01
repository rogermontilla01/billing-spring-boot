package com.billing.billing_system.service.SaleService;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.SaleModel.SaleRequestDto;
import com.billing.billing_system.model.SaleModel.SaleResponseDto;

import java.util.List;

public interface SaleService {
    SaleResponseDto createSale(SaleRequestDto newSaleEntity) throws ApiException;

    SaleResponseDto findOneById(Long id) throws ApiException;

    List<SaleResponseDto> findAll() throws ApiException;

    void deleteById(Long id) throws ApiException;
}
