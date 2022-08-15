package com.billing.billing_system.builder;

import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.billing.billing_system.model.InvoiceModel.InvoiceRequestDto;
import com.billing.billing_system.model.InvoiceModel.InvoiceResponseDto;
import com.billing.billing_system.model.SaleModel.SaleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvoiceBuilder extends EntityTransform<InvoiceResponseDto, InvoiceRequestDto, InvoiceEntity> {

    private final SaleBuilder saleBuilder;

    @Override
    public InvoiceResponseDto entityToResponse(InvoiceEntity invoice) {
        if (Objects.isNull(invoice)) return null;

        List<SaleResponseDto> saleList = saleBuilder.entityToResponseList(invoice.getSales());

        return InvoiceResponseDto.builder()
                .total(invoice.getTotal())
                .date(invoice.getDate())
                .clientId(invoice.getClient())
                .sales(saleList)
                .build();
    }

    @Override
    public InvoiceEntity requestToEntity(InvoiceRequestDto response) {
        return null;
    }

}
