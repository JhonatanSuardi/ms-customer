package com.financials.customer.business;

import com.financials.customer.api.dto.CustomerDto;
import com.financials.customer.domain.entities.Customer;
import com.financials.customer.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Customer> findCustomerById(String idCustomer){
        return customerRepository.findById(idCustomer);
    }

    public Customer updateCustomer(Customer customer, CustomerDto customerDto){
        //Coloquei a senha como opcional no DTO
        //Podemos criar uma validação de senha pra isso

        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());

        return customerRepository.save(customer);
    }

//    public void deleteCustomer(final String id){
//        Customer customer = customerRepository.findByIdentifier(UUID.fromString(id))
//                .orElseThrow(() -> new EntityNotFoundException("Could not find the entity to delete"));
//
//        customerRepository.delete(customer);
//    }
}
