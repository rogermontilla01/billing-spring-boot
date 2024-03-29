package com.billing.billing_system.model.ClientModel;

import com.billing.billing_system.model.InvoiceModel.InvoiceEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "CLIENT")
public class ClientEntity {
    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "DNI", unique = true)
    private Long dni;

    @Column(name = "EMAIL")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<InvoiceEntity> invoice;

    @Id
    @Hidden
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
