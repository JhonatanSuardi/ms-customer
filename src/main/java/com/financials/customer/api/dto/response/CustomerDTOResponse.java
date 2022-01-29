package com.financials.customer.api.dto.response;

import com.financials.customer.domain.entities.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDTOResponse {

    private String uuid;
    private String name;
    private String email;
    private Boolean activeStatus;

    public static CustomerDTOResponse valueOf(Customer customer) {
        return CustomerDTOResponse.builder()
                .uuid(customer.getUuid())
                .name(customer.getName())
                .email(customer.getEmail())
                .activeStatus(customer.getActiveStatus())
                .build();
    }

}
