package com.billing.billing_system.model.InvoiceModel;

import com.billing.billing_system.model.ProductModel.ProductInvoiceDto;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Data
@Validated
public class InvoiceRequestDto {
    @NotNull(message = "clientDni is required")
    private Long clientDni;

    @NotNull(message = "productList is required")
    private List<ProductInvoiceDto> product;
}
