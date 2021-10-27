package com.financials.customer.domain.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class Customer {
    private UUID uuid;
    private String name;
    private String email;
    private String password;
    private Boolean activeStatus;
}
