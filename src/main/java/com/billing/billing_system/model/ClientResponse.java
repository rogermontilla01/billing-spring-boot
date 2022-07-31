package com.billing.billing_system.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ClientResponse {

    private String firstname;

    private String lastname;

    private String email;

    private Long dni;

    private Long id;

}
