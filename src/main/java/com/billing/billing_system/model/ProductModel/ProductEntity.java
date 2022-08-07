package com.billing.billing_system.model.ProductModel;

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
@Table(name = "PRODUCT")
public class ProductEntity {
    @Column(name = "PRODUCT_NAME")
    public String productName;

    @Column(name = "QUANTITY")
    public Long quantity;

    @Column(name = "PRICE")
    public BigDecimal price;

    @Column(name = "DESCRIPTION")
    public String description;

    @Column(name = "CODE", unique = true)
    public Integer code;

    @Id
    @Hidden
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public Long id;
}
