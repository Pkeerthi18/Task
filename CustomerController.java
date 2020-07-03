package com.example.demoMongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String create(@RequestBody List<Customer> cust) {

		customerService.createCustomer(cust);
		return "Customer records created";

	}

	@GetMapping(path = "/getall")
	public List<Customer> getAll() {

		return customerService.getAllCustomers();
	}

	@GetMapping(path = "/getbyid/{id}")
	public Optional<Customer> getById(@PathVariable int id) {

		return customerService.getCustomer(id);
	}

}
