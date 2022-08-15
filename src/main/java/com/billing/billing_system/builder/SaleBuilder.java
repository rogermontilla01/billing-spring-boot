package com.billing.billing_system.builder;

import com.billing.billing_system.model.SaleModel.CreateSaleDto;
import com.billing.billing_system.model.SaleModel.SaleEntity;
import com.billing.billing_system.model.SaleModel.SaleRequestDto;
import com.billing.billing_system.model.SaleModel.SaleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SaleBuilder extends EntityTransform<SaleResponseDto, SaleRequestDto, SaleEntity>{

    @Override
    public SaleResponseDto entityToResponse(SaleEntity sale) {
        if(Objects.isNull(sale)) return null;

        return SaleResponseDto.builder()
                .quantity(sale.getQuantity())
                .description(sale.getDescription())
                .price(sale.getPrice())
                .productCode(sale.getProductId().getCode())
                .productName(sale.getProductId().getProductName())
                .invoiceId(sale.getInvoiceId().getId())
                .build();
    }

    @Override
    public SaleEntity requestToEntity(SaleRequestDto sale) {
        if(Objects.isNull(sale)) return null;

        return SaleEntity.builder()
                .quantity(sale.getQuantity())
                .description(sale.getDescription())
                .price(sale.getPrice())
                .productId(sale.getProductId())
                .build();
    }

    public SaleEntity createSaleToEntity(CreateSaleDto sale) {
        if(Objects.isNull(sale)) return null;

        return SaleEntity.builder()
                .quantity(sale.getQuantity())
                .description(sale.getDescription())
                .price(sale.getPrice())
                .productId(sale.getProductId())
                .invoiceId(sale.getInvoice())
                .build();
    }
}
