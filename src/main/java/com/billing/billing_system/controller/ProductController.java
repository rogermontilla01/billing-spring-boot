package com.billing.billing_system.controller;

import com.billing.billing_system.model.ProductEntity;
import com.billing.billing_system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("create")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity newProduct) {
        return ResponseEntity.ok(productService.createProduct(newProduct));
    }

    @GetMapping("all")
    public ResponseEntity<List<ProductEntity>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<ProductEntity> getOneById(@PathVariable() Long id) {
        return ResponseEntity.ok(productService.findOneById(id));
    }

    @GetMapping("get-by-code/{code}")
    public ResponseEntity<ProductEntity> getProductByCode(@PathVariable Integer code) {
        return ResponseEntity.ok(productService.findByCode(code));
    }

    @GetMapping("get-by-name/{name}")
    public ResponseEntity<ProductEntity> getProductByName(@PathVariable String name) {
        return ResponseEntity.ok(productService.findByProductName(name));
    }

    @DeleteMapping("delete-by-id/{id}")
    public void deleteClient(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
