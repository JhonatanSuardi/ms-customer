package com.financials.customer.business;

import com.financials.customer.api.dto.CustomerDto;
import com.financials.customer.api.dto.response.CustomerDTOResponse;
import com.financials.customer.core.exceptions.EntityNotFoundException;
import com.financials.customer.domain.entities.Customer;
import com.financials.customer.domain.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Customer getCustomer(String uuid) {
        return customerRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Could not find customer"));
    }

    public CustomerDTOResponse getCustomerInfo(String uuid) {
        Customer getCustomer = this.getCustomer(uuid);

        return CustomerDTOResponse.valueOf(getCustomer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer insertCustomer(final CustomerDto customerDto) {
        return customerRepository.save(Customer.valueOf(customerDto));
    }

    public Page<Customer> getAllPaginated(Pageable requestPage) {

        return customerRepository.findAll(requestPage);
    }

    public void patchCustomer(final String uuid, final CustomerDto customerDto) {
        customerRepository.findByUuid(uuid)
                .map(customer -> customer.patchfields(customerDto))
                .map(customerRepository::save)
                .orElseThrow(() -> new EntityNotFoundException("could not find the customer to update"));
        //Renomeei o verbo do método para patch já que possui campos opcionais
        //Temos que implementar o put se necessário
        //Podemos criar uma validação de senha pra isso - Sim
    }

    public void deleteCustomer(String id) {
        Customer customer = this.getCustomer(id);
        customerRepository.delete(customer);
    }


}
