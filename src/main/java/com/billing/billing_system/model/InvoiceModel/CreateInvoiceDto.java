package com.billing.billing_system.model.InvoiceModel;

import com.billing.billing_system.model.ClientModel.ClientEntity;
import com.billing.billing_system.model.SaleModel.SaleEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class CreateInvoiceDto {

    public Date date;

    public BigDecimal total;

    public ClientEntity clientId;

    public List<SaleEntity> sales;

}