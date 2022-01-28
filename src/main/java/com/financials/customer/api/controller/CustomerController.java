package com.financials.customer.api.controller;

import com.financials.customer.api.dto.CustomerDto;
import com.financials.customer.business.CustomerService;
import com.financials.customer.domain.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/custommers")
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getHelloWorld() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("page")
    public Page<Customer> getAllPaginated(@Param(value = "page") int page, @Param(value = "size") int size) {
        Pageable requestPage = PageRequest.of(page, size);
        return customerService.getAllPaginated(requestPage);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Customer> creatCustomer(@RequestBody @Valid final CustomerDto customerDto) {
        Customer createdCustomer = customerService.insertCustomer(customerDto);
        return ResponseEntity.ok(createdCustomer);
    }

    @PatchMapping("/{patchId}")
    @Validated
    public ResponseEntity<Customer> updateCustomer(@PathVariable("patchId") String patchId, @RequestBody @Valid CustomerDto customerDto) {
            customerService.patchCustomer(patchId, customerDto);
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


}
