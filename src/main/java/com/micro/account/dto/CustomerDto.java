package com.micro.account.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class CustomerDto {

	private String name;

	private String email;

	private String mobileNumber;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<AccountDto> accountDto;

	public CustomerDto() {
		super();
	}

	public CustomerDto(String name, String email, String mobileNumber, List<AccountDto> accountDto) {
		super();
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.accountDto = accountDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<AccountDto> getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(List<AccountDto> accountDto) {
		this.accountDto = accountDto;
	}

}
