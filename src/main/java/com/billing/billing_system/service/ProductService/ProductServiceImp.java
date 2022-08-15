package com.billing.billing_system.service.ProductService;

import com.billing.billing_system.builder.ProductBuilder;
import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ProductModel.ProductEntity;
import com.billing.billing_system.model.ProductModel.ProductInvoiceDto;
import com.billing.billing_system.model.ProductModel.ProductRequestDto;
import com.billing.billing_system.model.ProductModel.ProductResponseDto;
import com.billing.billing_system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;
    private final ProductBuilder productBuilder;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto product) throws ApiException {
        try {
            if (productRepository.existsByCode(product.getCode())) {
                throw new ApiException(String.format("Product with code %s already exist...", product.getCode()));
            }

            ProductEntity productEntity = productRepository.save(productBuilder.requestToEntity(product));

            return productBuilder.entityToResponse(productEntity);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public ProductResponseDto findOneById(Long id) throws ApiException {
        try {
            return productBuilder.entityToResponse(productRepository.findOneById(id));
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public ProductEntity findProductByCode(Integer code) throws ApiException {
        try {
            ProductEntity productEntity = productRepository.findOneByCode(code);
            if (productEntity == null) {
                String message = String.format("Product with code: %s does not exist...", code);
                throw new ApiException(message);
            }
            return productEntity;
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public List<ProductResponseDto> findAll() throws ApiException {
        try {
            return productBuilder.entityToResponseList(productRepository.findAll());
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }

    }

    @Override
    public ProductResponseDto findByCode(Integer code) throws ApiException {
        try {
            return productBuilder.entityToResponse(productRepository.findOneByCode(code));
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }

    }

    @Override
    public ProductResponseDto findByProductName(String productName) throws ApiException {
        try {
            return productBuilder.entityToResponse(productRepository.findByProductName(productName));
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }

    }

    @Override
    public void updateProductQuantity(ProductInvoiceDto productInvoice) throws ApiException {
        try {
            ProductEntity product = productRepository.findOneByCode(productInvoice.getCode());
            product.setQuantity(product.getQuantity() - productInvoice.getQuantity());
            productRepository.save(product);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) throws ApiException {
        try {
            productRepository.deleteById(id);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }

    }
}
