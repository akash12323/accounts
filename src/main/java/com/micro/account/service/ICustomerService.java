package com.micro.account.service;

import java.util.List;

import com.micro.account.dto.CustomerDto;

public interface ICustomerService {
	
	public void createCustomerAccount(CustomerDto customerDto);
	
	public void updateCustomer(CustomerDto customerDto);
	
	public void deleteCustomer(String mobileNumber);
	
	public List<CustomerDto> getAllCustomers();
	
	public CustomerDto getCustomerById(long id);

}
