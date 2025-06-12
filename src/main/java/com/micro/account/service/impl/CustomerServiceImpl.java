package com.micro.account.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.micro.account.dto.AccountDto;
import com.micro.account.dto.CustomerDto;
import com.micro.account.dto.transformer.AccountMapper;
import com.micro.account.dto.transformer.CustomerMapper;
import com.micro.account.entity.Accounts;
import com.micro.account.entity.Customer;
import com.micro.account.exception.CustomerAlreadyExistsException;
import com.micro.account.repository.AccountRepository;
import com.micro.account.repository.CustomerRepository;
import com.micro.account.service.ICustomerService;

import jakarta.transaction.Transactional;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	private CustomerRepository customerRepo;
	private AccountRepository accountRepo;
	
	public CustomerServiceImpl(CustomerRepository customerRepo, AccountRepository accountRepo) {
		this.customerRepo = customerRepo;
		this.accountRepo = accountRepo;
	}
	
	@Override
	@Transactional
	public void createCustomerAccount(CustomerDto customerDto) {
		LOGGER.info("Creating new customer started...");
		Customer customer = CustomerMapper.transformToCustomer(customerDto);
//		Accounts account = this.createAccount();
//		account.setCustomer(customer);
//		this.accountRepo.save(account);
		List<Accounts> account = this.createAccount(customerDto.getAccountDto());
		customer.setAccounts(account);
		this.customerRepo.save(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Optional<Customer> c = this.customerRepo.findByMobileNumber(customerDto.getMobileNumber());
		if(!c.isPresent()) {
			throw new CustomerAlreadyExistsException("Please enter a valid customer mobile number"); 
		}
		Customer customer = null;
		if(Objects.nonNull(customerDto.getAccountDto()) && customerDto.getAccountDto().size() > 0) {
			customer = CustomerMapper.transformToCustomer(customerDto, customerDto.getAccountDto());
		} else {
			customer = CustomerMapper.transformToCustomer(customerDto);
		}
		customer.setCustomerId(c.get().getCustomerId());
		customer.setCreatedAt(c.get().getCreatedAt());
		this.customerRepo.save(customer);
	}
	
	private Accounts createAccount() {
		Accounts account = new Accounts();
		
		long accountNumber = 1000000000L + new Random().nextInt(900000000);
		
		account.setAccountNumber(accountNumber);
		account.setAccountType("SAVINGS");
		account.setBranchAddress("Temp branch address");
		
		return account;
	}
	
	private List<Accounts> createAccount(List<AccountDto> accountDtos) {
		List<Accounts> accounts = new ArrayList<>();
		
		if(Objects.nonNull(accountDtos) && accountDtos.size() > 0) {
			accountDtos.stream().forEach(accountDto->{
				Accounts account = new Accounts();
				long accountNumber = 1000000000L + new Random().nextInt(900000000);
				account.setAccountNumber(accountNumber);
				account.setAccountType(accountDto.getAccountType());
				account.setBranchAddress(accountDto.getBranchAddress());
				accounts.add(account);
			});
		} else {
			accounts.add(this.createAccount());
		}
		return accounts;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = this.customerRepo.findAll();
		List<CustomerDto> customerDtos = customers.stream().map(customer-> CustomerMapper.transformToCustomerDto(customer, customer.getAccounts())).collect(Collectors.toList());
		return customerDtos;
	}

	@Override
	public CustomerDto getCustomerById(long id) {
		Optional<Customer> customer = this.customerRepo.findById(id);
		if(!customer.isPresent()) {
			throw new CustomerAlreadyExistsException("No customer found");
		}
		return CustomerMapper.transformToCustomerDto(customer.get(), customer.get().getAccounts());
	}

	@Override
	@Transactional
	public void deleteCustomer(String mobileNumber) {
		Optional<Customer> c = this.customerRepo.findByMobileNumber(mobileNumber);
		if(!c.isPresent()) {
			throw new CustomerAlreadyExistsException("Please enter a valid customer mobile number"); 
		}
		this.customerRepo.deleteByMobileNumber(mobileNumber);
		
	}

}
