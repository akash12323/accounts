package com.micro.account.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.micro.account.dto.CustomerDto;
import com.micro.account.dto.ResponseDto;
import com.micro.account.service.ICustomerService;

@RestController
public class CustomerController {

	private ICustomerService customerService;
	
	public CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customer")
	public ResponseEntity<ResponseDto> getCustomers() {
		List<CustomerDto> response = this.customerService.getAllCustomers();
		return new ResponseEntity<ResponseDto>(new ResponseDto(response, "success"),HttpStatus.OK);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<ResponseDto> getCustomers(@PathVariable("id") long id) {
		CustomerDto response = this.customerService.getCustomerById(id);
		return new ResponseEntity<ResponseDto>(new ResponseDto(response, "success"),HttpStatus.OK);
	}

	@PostMapping("customer")
	public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerDto customer) {
		this.customerService.createCustomerAccount(customer);
		return new ResponseEntity<>(new ResponseDto(null, "customer account created successfully"), HttpStatus.CREATED);
	}
	
	@PutMapping("customer")
	public ResponseEntity<ResponseDto> updateCustomer(@RequestBody CustomerDto customer) {
		this.customerService.updateCustomer(customer);
		return new ResponseEntity<>(new ResponseDto(null, "customer details updated successfully"), HttpStatus.CREATED);
	}
	
	@DeleteMapping("customer")
	public ResponseEntity<ResponseDto> deleteCustomer(@RequestParam String mobileNumber) {
		this.customerService.deleteCustomer(mobileNumber);
		return new ResponseEntity<>(new ResponseDto(), HttpStatus.OK);
	}
}
