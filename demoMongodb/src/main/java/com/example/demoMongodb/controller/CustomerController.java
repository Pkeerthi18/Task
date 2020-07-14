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
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping(path = "/create")
	public Customer create(@RequestBody Customer cust) {

		customerService.createCustomer(cust);
		return cust;

	}

	@GetMapping(path = "/")
	public List<Customer> getAll() {

		return customerService.getAllCustomers();
	}

	@GetMapping(path = "/getbyid/{id}")
	public Optional<Customer> getById(@PathVariable int id) {

		return customerService.getCustomer(id);

	}

	@PutMapping("/update/{id}")
	public String update(@PathVariable Integer id, @RequestBody Customer user) {
		customerService.update(id, user);
		return "Customer is updated successsfully";

	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		customerService.delete(id);
		return "Customer deleted successfully";
	}

}
