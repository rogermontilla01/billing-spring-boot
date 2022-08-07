package com.billing.billing_system.service.SaleService;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ProductModel.ProductInvoiceDto;
import com.billing.billing_system.model.SaleModel.SaleEntity;
import com.billing.billing_system.model.SaleModel.SaleResponseDto;

import java.util.List;

public interface SaleService {

    SaleEntity createSale(ProductInvoiceDto productInvoice) throws ApiException;

    SaleResponseDto findOneById(Long id) throws ApiException;

    List<SaleResponseDto> findAll() throws ApiException;

    void deleteById(Long id) throws ApiException;
}
