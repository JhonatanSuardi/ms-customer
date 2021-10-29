package com.financials.customer.api.controller;

import com.financials.customer.api.dto.CustomerDto;
import com.financials.customer.business.CustomerService;
import com.financials.customer.domain.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/custommers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<Customer>> getHelloWorld(){

        List<Customer> customers = service.getAllCustomers();

        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<Customer> creatCustomer(@RequestBody @Valid CustomerDto customerDto){

        Customer createdCustomer = service.insertCustomer(customerDto);

        return ResponseEntity.ok(createdCustomer);
    }



}
