package com.billing.billing_system.controller;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.InvoiceModel.InvoiceRequestDto;
import com.billing.billing_system.model.InvoiceModel.InvoiceResponseDto;
import com.billing.billing_system.service.InvoiceService.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    @PostMapping("create")
    public ResponseEntity<InvoiceResponseDto> createInvoice(@RequestBody InvoiceRequestDto invoice) throws ApiException {
        return ResponseEntity.ok(invoiceService.createInvoice(invoice));
    }

    @GetMapping("get-all")
    public ResponseEntity<List<InvoiceResponseDto>> getAllInvoice() throws ApiException {
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @GetMapping("get-by-code/{code}")
    public ResponseEntity<InvoiceResponseDto> getInvoiceByCode(@PathVariable Long code) throws ApiException {
        return ResponseEntity.ok(invoiceService.findOneById(code));
    }

}
