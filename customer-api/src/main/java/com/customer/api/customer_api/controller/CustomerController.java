package com.customer.api.customer_api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.api.customer_api.entity.Customer;
import jakarta.validation.Valid;
import com.customer.api.customer_api.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@PostMapping
	public ResponseEntity<Customer> create(@RequestBody @Valid Customer customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(customer));
	}

	@GetMapping
	public List<Customer> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public Customer getById(@PathVariable UUID id) {
		return service.getById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable UUID id) {
		service.delete(id);
	}

}
