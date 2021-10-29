package com.financials.customer.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class Customer {
    @Id
    private Long id;
    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private Boolean activeStatus;
}
