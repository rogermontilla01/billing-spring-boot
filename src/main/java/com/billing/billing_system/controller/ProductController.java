package com.billing.billing_system.controller;

import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ProductModel.ProductRequestDto;
import com.billing.billing_system.model.ProductModel.ProductResponseDto;
import com.billing.billing_system.service.ProductService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("create")
    public ResponseEntity<ProductResponseDto> createProduct(@Valid @RequestBody ProductRequestDto newProduct) throws ApiException {
        return ResponseEntity.ok(productService.createProduct(newProduct));
    }

    @GetMapping("all")
    public ResponseEntity<List<ProductResponseDto>> findAll() throws ApiException {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<ProductResponseDto> getOneById(@PathVariable() Long id) throws ApiException{
        return ResponseEntity.ok(productService.findOneById(id));
    }

    @GetMapping("get-by-code/{code}")
    public ResponseEntity<ProductResponseDto> getProductByCode(@PathVariable Integer code) throws ApiException {
        return ResponseEntity.ok(productService.findByCode(code));
    }

    @GetMapping("get-by-name/{name}")
    public ResponseEntity<ProductResponseDto> getProductByName(@PathVariable String name) throws ApiException {
        return ResponseEntity.ok(productService.findByProductName(name));
    }

    @DeleteMapping("delete-by-id/{id}")
    public void deleteClient(@PathVariable Long id) throws ApiException {
        productService.deleteById(id);
    }
}
