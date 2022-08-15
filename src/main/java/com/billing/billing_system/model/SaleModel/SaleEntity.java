package com.billing.billing_system.model.SaleModel;

import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.billing.billing_system.model.ProductModel.ProductEntity;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "SALE")
public class SaleEntity {

    private Integer quantity;

    private String description;

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = InvoiceEntity.class)
    @JoinColumn(name = "INVOICE_ID", nullable = false, referencedColumnName = "id")
    private InvoiceEntity invoiceId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productId;

    @Id
    @Hidden
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
