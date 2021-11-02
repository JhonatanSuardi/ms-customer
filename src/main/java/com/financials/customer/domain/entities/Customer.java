package com.financials.customer.domain.entities;

import com.financials.customer.api.dto.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
@Builder
@AllArgsConstructor
public class Customer {
    @Id
    private String uuid;
    private String name;
    private String email;
    private String password;
    private Boolean activeStatus;

    public static Customer valueOf(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .password(customerDto.getPassword())
                .activeStatus(true)
                .build();
    }
}
