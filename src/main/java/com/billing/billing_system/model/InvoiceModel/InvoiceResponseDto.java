package com.billing.billing_system.model.InvoiceModel;

import com.billing.billing_system.model.ClientModel.ClientEntity;
import com.billing.billing_system.model.SaleModel.SaleResponseDto;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
public class InvoiceResponseDto {

    private Date date;

    private BigDecimal total;

    private ClientEntity clientId;

    private List<SaleResponseDto> sales;
}
