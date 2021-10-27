package com.financials.customer.api.controller;

import com.financials.customer.api.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/custommers")
public class CustomerController {

    @GetMapping
    public ResponseEntity<String> getHelloWorld(){
        return ResponseEntity.ok("Hello customer!");
    }

    @PostMapping
    public ResponseEntity<String> creatCustomer(@RequestBody @Valid CustomerDto customerDto){
        return ResponseEntity.ok(customerDto.toString());
    }



}
