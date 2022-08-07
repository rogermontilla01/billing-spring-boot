package com.billing.billing_system.controller;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.SaleModel.SaleResponseDto;
import com.billing.billing_system.service.SaleService.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sales")
public class SaleController {

    private final SaleService saleService;

    @GetMapping("all")
    public ResponseEntity<List<SaleResponseDto>> getAll() throws ApiException {
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<SaleResponseDto> getById(@PathVariable Long id) throws ApiException {
        return ResponseEntity.ok(saleService.findOneById(id));
    }

    @DeleteMapping("delete-by-id/{id}")
    public void deleteSale(@PathVariable Long id) throws ApiException {
        saleService.deleteById(id);
    }
}
