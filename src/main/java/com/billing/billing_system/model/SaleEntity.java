package com.billing.billing_system.model;

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

    private String Description;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "INVOICE_ID")
    private InvoiceEntity invoiceId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productId;

    @Id
    @Hidden
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
