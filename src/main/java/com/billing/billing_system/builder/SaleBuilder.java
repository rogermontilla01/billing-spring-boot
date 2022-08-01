package com.billing.billing_system.builder;

import com.billing.billing_system.model.SaleModel.SaleEntity;
import com.billing.billing_system.model.SaleModel.SaleRequestDto;
import com.billing.billing_system.model.SaleModel.SaleResponseDto;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SaleBuilder extends EntityTransform<SaleResponseDto, SaleRequestDto, SaleEntity>{
    @Override
    public SaleResponseDto entityToResponse(SaleEntity sale) {
        if(Objects.isNull(sale)) return null;

        return SaleResponseDto.builder()
                .quantity(sale.getQuantity())
                .description(sale.getDescription())
                .price(sale.getPrice())
                .invoiceId(sale.getInvoiceId())
                .productId(sale.getProductId())
                .build();
    }

    @Override
    public SaleEntity requestToEntity(SaleRequestDto sale) {
        if(Objects.isNull(sale)) return null;

        return SaleEntity.builder()
                .quantity(sale.getQuantity())
                .description(sale.getDescription())
                .price(sale.getPrice())
                .invoiceId(sale.getInvoiceId())
                .productId(sale.getProductId())
                .build();
    }
}
