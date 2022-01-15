package com.financials.customer;

import com.financials.customer.domain.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
public class CustomerApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
