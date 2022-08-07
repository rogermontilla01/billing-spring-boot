package com.billing.billing_system.controller;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.billing.billing_system.model.InvoiceModel.InvoiceRequestDto;
import com.billing.billing_system.service.InvoiceService.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @PostMapping("create")
    public InvoiceEntity createInvoice(@RequestBody InvoiceRequestDto invoice) throws ApiException {
        return invoiceService.createInvoice(invoice);
    }

}
