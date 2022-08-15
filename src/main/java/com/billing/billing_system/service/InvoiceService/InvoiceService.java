package com.billing.billing_system.service.InvoiceService;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.InvoiceModel.InvoiceRequestDto;
import com.billing.billing_system.model.InvoiceModel.InvoiceResponseDto;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDto createInvoice(InvoiceRequestDto invoice) throws ApiException;

    InvoiceResponseDto findOneById(Long id) throws ApiException;

    List<InvoiceResponseDto> findAll() throws ApiException;
}
