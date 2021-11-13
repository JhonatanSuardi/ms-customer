package com.financials.customer.api.controller;

import com.financials.customer.api.dto.CustomerDto;
import com.financials.customer.business.CustomerService;
import com.financials.customer.domain.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Optional;

@RestController
@RequestMapping("/custommers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getHelloWorld(){

        List<Customer> customers = customerService.getAllCustomers();

        return ResponseEntity.ok(customers);
    }

    @GetMapping("page")
    public Page<Customer> getAllPaginated(@Param(value = "page") int page, @Param(value = "size") int size){

        Pageable requestPage = PageRequest.of(page, size);

        return  customerService.getAllPaginated(requestPage);
    }

    @PostMapping
    @Validated
    public ResponseEntity<Customer> creatCustomer(@RequestBody @Valid final CustomerDto customerDto){

        Customer createdCustomer = customerService.insertCustomer(customerDto);

        return ResponseEntity.ok(createdCustomer);
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody @Valid CustomerDto customerDto){
        Optional<Customer> customer = customerService.findCustomerById(id);

        if(customer.isPresent()){
            Customer updatedCustomer = customerService.updateCustomer(customer.get(), customerDto);
            return  ResponseEntity.ok(updatedCustomer);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

//    @DeleteMapping
//    public ResponseEntity<Void> deleteCustomer(@RequestParam final String id) {
//
//        customerService.deleteCustomer(id);
//        // doubts: how does the getHttpStatus in an exception is treated in the respone entity (@ExceptionHandler??)
//        // if so how the controller advice gets an abstract exception to do the getHttpStatus for
//        return ResponseEntity.noContent().build();
//    }


}
