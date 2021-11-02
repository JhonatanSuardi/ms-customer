package com.financials.customer.domain.repository;

import com.financials.customer.domain.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByUuid(final UUID identifierUuid);
    // is counting how many emails is equal the email that was passed
    Optional<Long> countByEmail(final String email);
}
