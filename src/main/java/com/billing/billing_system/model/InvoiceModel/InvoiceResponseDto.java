package com.billing.billing_system.model.InvoiceModel;

import com.billing.billing_system.model.ClientModel.ClientEntity;
import com.billing.billing_system.model.SaleModel.SaleEntity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class InvoiceResponseDto {

    //create a list of sales that is going to have the quantities
    //of one product
    private Integer quantity;

    private Date date;

    private BigDecimal total;

    private ClientEntity clientId;

    private List<SaleEntity> sales;
}
