package com.micro.account.dto.transformer;

import java.util.List;
import java.util.stream.Collectors;

import com.micro.account.dto.AccountDto;
import com.micro.account.dto.CustomerDto;
import com.micro.account.entity.Accounts;
import com.micro.account.entity.Customer;

public class CustomerMapper {
	
	public static CustomerDto transformToCustomerDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobileNumber(customer.getMobileNumber());
		customerDto.setName(customer.getName());
		return customerDto;
	}
	
	public static CustomerDto transformToCustomerDto(Customer customer, List<Accounts> accounts) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobileNumber(customer.getMobileNumber());
		customerDto.setName(customer.getName());
		customerDto.setAccountDto(accounts.stream().map(account-> AccountMapper.transformToAccountDto(account)).collect(Collectors.toList()));
		return customerDto;
	}
	
	public static Customer transformToCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setName(customerDto.getName());
		return customer;
	}
	
	public static Customer transformToCustomer(CustomerDto customerDto, List<AccountDto> accountDtos) {
		Customer customer = new Customer();
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		customer.setName(customerDto.getName());
		customer.setAccounts(accountDtos.stream().map(accountDto-> AccountMapper.transformToAccount(accountDto)).collect(Collectors.toList()));
		return customer;
	}

}
