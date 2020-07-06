package com.example.demoMongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoMongodb.model.Customer;
import com.example.demoMongodb.service.CustomerService;

@RestController
@RequestMapping(path = "/mongodb")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping(path = "/create")
	public Customer create(@RequestBody Customer cust) {

		customerService.createCustomer(cust);
		return cust;

	}

	@GetMapping(path = "/getall")
	public List<Customer> getAll() {

		return customerService.getAllCustomers();
	}

	@GetMapping(path = "/getbyid/{id}")
	public Optional<Customer> getById(@PathVariable int id) {

		return customerService.getCustomer(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody Customer user, @PathVariable Integer id) {
		customerService.update(id, user);

	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		customerService.delete(id);
	}



}
