package com.financials.customer.domain.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
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
}
