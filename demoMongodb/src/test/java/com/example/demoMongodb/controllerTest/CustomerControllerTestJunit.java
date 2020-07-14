package com.example.demoMongodb.controllerTest;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.springframework.http.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demoMongodb.model.Customer;

public class CustomerControllerTestJunit extends AbstractTest {

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void testCreateCustomer() throws Exception {
		String uri = "/customers/create";
		Customer customer = new Customer();
		customer.setId(105);
		customer.setName("sai");
		customer.setAddress("Hyderabad");
		String inputJson = super.mapToJson(customer);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void testGetAllCustomers() throws Exception {
		String uri = "/customers/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Customer[] customerList = super.mapFromJson(content, Customer[].class);
		assertTrue(customerList.length > 0);

	}

	@Test
	public void testGetCustomer() throws Exception {
		String uri = "/customers/getbyid/103";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Test
	public void updateCustomer() throws Exception {
		String uri = "/customers/update/102";
		Customer customer = new Customer();
		customer.setId(102);
		customer.setName("Srihari");
		customer.setAddress("mahabubnagar");
		String inputJson = super.mapToJson(customer);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Customer is updated successsfully");

	}

	@Test
	public void deleteCustomer() throws Exception {
		String uri = "/customers/delete/100";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Customer deleted successfully");

	}

}