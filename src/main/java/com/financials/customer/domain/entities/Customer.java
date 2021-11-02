package com.financials.customer.domain.entities;

import com.financials.customer.api.dto.CustomerDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Customer {
    @Id
    private String uuid;
    private String name;
    private String email;
    private String password;
    private Boolean activeStatus;

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.activeStatus=true;
    }

    public static Customer valueOf(CustomerDto customerDto) {
        // where should we set the active status?
        return Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .password(customerDto.getPassword())
                .build();
    }
}
