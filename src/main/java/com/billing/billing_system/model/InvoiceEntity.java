package com.billing.billing_system.model;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "INVOICE")
public class InvoiceEntity {
    @Column(name = "QUANTITY")
    private Integer quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE")
    private Date date;

    @Column(name = "TOTAL")
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private ClientEntity clientId;

    @OneToMany(mappedBy = "invoiceId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SaleEntity> sales;

    @Id
    @Hidden
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
