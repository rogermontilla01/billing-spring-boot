package com.billing.billing_system.model;


import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class ClientRequest {
    @NotNull(message = "name is required")
    @NotBlank(message = "name can't be empty")
    private String firstname;

    @NotNull(message = "lastname is required")
    @NotBlank(message = "lastname can't be empty")
    private String lastname;

    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "dni is required")
    private Long dni;
}
