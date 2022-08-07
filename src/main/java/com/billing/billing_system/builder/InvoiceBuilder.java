package com.billing.billing_system.builder;

import com.billing.billing_system.model.InvoiceModel.CreateInvoiceDto;
import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.billing.billing_system.model.InvoiceModel.InvoiceRequestDto;
import com.billing.billing_system.model.InvoiceModel.InvoiceResponseDto;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class InvoiceBuilder extends EntityTransform<InvoiceResponseDto, InvoiceRequestDto, InvoiceEntity> {

    @Override
    public InvoiceResponseDto entityToResponse(InvoiceEntity invoice) {
        if (Objects.isNull(invoice)) return null;

        return InvoiceResponseDto.builder()
                .total(invoice.getTotal())
                .clientId(invoice.getClient())
                .build();
    }

    @Override
    public InvoiceEntity requestToEntity(InvoiceRequestDto response) {
        return null;
    }

    public InvoiceEntity createInvoiceToEntity(CreateInvoiceDto invoice) {
        return InvoiceEntity.builder()
                .total(invoice.getTotal())
                .client(invoice.getClientId())
                .sales(invoice.getSales())
                .build();
    }
}
