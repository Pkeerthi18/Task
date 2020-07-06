package com.example.demoMongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoMongodb.model.Customer;
import com.example.demoMongodb.repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	public Customer createCustomer(Customer cust) {
		customerRepo.save(cust);
		return cust;

	}

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public Optional<Customer> getCustomer(int id) {
		return Optional.of(customerRepo.findById(id));

	}
	
	public Customer update(int id, Customer cust) {
		customerRepo.save(cust);
		return cust;
		}
	
	public void delete(int id) {
		customerRepo.deleteById(id);
	}

}
