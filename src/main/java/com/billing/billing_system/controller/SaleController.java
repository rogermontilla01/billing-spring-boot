package com.billing.billing_system.controller;

import com.billing.billing_system.model.SaleEntity;
import com.billing.billing_system.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("sales")
public class SaleController {

    private final SaleService saleService;

    @PostMapping("create")
    public ResponseEntity<SaleEntity> createSale(@RequestBody SaleEntity newSale) {
        return ResponseEntity.ok(saleService.createSale(newSale));
    }

    @GetMapping("all")
    public ResponseEntity<List<SaleEntity>> getAll() {
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<SaleEntity> getById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.findOneById(id));
    }

    @DeleteMapping("delete-by-id/{id}")
    public void deleteSale(@PathVariable Long id) {
        saleService.deleteById(id);
    }
}
