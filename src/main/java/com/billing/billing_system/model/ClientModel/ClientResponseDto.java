package com.billing.billing_system.model.ClientModel;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ClientResponseDto {

    private String firstname;

    private String lastname;

    private String email;

    private Long dni;

    private Long id;

}
