package com.billing.billing_system.service.SaleService;

import com.billing.billing_system.builder.SaleBuilder;
import com.billing.billing_system.handle.ApiException;
import com.billing.billing_system.model.ProductModel.ProductEntity;
import com.billing.billing_system.model.ProductModel.ProductInvoiceDto;
import com.billing.billing_system.model.SaleModel.SaleEntity;
import com.billing.billing_system.model.SaleModel.SaleResponseDto;
import com.billing.billing_system.repository.SaleRepository;
import com.billing.billing_system.service.ProductService.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImp implements SaleService {

    private final SaleRepository saleRepository;
    private final ProductService productService;
    private final SaleBuilder saleBuilder;

    @Override
    public SaleEntity createSaleEntity(ProductInvoiceDto productInvoice) throws ApiException {

        try {
            SaleEntity createSale = new SaleEntity();
            ProductEntity product = productService.findProductByCode(productInvoice.getCode());

            if(product.getQuantity() >= productInvoice.getQuantity()) {
                createSale.setQuantity(productInvoice.getQuantity());
                createSale.setDescription(product.getDescription());
                createSale.setPrice(product.getPrice());
                createSale.setProductId(product);

                return createSale;
            } else {
                throw new ApiException("Not enough products...");
            }

        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public SaleResponseDto findOneById(Long id) throws ApiException {
        try {
            return saleBuilder.entityToResponse(saleRepository.findOneById(id));
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public List<SaleResponseDto> findAll() throws ApiException {
        try {
            return saleBuilder.entityToResponseList(saleRepository.findAll());
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) throws ApiException {
        try {
            saleRepository.deleteById(id);
        } catch (Exception error) {
            throw new ApiException(error.getMessage());
        }

    }
}
