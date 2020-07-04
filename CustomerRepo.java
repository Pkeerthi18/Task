package com.example.demoMongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demoMongodb.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Integer> {
	
	public Customer findById(int id);

}
