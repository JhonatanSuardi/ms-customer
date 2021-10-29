package com.financials.customer.business;

import com.financials.customer.api.dto.CustomerDto;
import com.financials.customer.domain.entities.Customer;
import com.financials.customer.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers(){

        return customerRepository.findAll();
    }

    public Customer insertCustomer(CustomerDto customerDto){
        Customer c = new Customer(customerDto.getName(), customerDto.getEmail(), customerDto.getPassword());

        return customerRepository.save(c);
    }


    public Page<Customer> getAllPaginated(Pageable requestPage) {

        return customerRepository.findAll(requestPage);
    }
}
