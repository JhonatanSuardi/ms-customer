package com.financials.customer.business;

import com.financials.customer.api.dto.CustomerDto;
import com.financials.customer.core.exceptions.EntityNotFoundException;
import com.financials.customer.domain.entities.Customer;
import com.financials.customer.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers(){

        return customerRepository.findAll();
    }

    public Customer insertCustomer(final CustomerDto customerDto){

        return customerRepository.save(Customer.valueOf(customerDto));
    }


    public Page<Customer> getAllPaginated(Pageable requestPage) {

        return customerRepository.findAll(requestPage);
    }

    public void deleteCustomer(final String id){
        Customer customer = customerRepository.findByIdentifier(UUID.fromString(id))
                .orElseThrow(() -> new EntityNotFoundException("Could not find the entity to delete"));

        customerRepository.delete(customer);
    }
}
