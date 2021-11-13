package com.financials.customer.api.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class CustomerDto {
    @NotBlank(message = "name cannot be null or blank")
    private String name;
    @NotBlank
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Invalid emaill")
    private String email;

    private String password;
}
