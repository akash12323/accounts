package com.micro.account.dto;

public class AccountDto {

	private Long accountNumber;

	private String accountType;

	private String branchAddress;

	private Long customer_id;

	public AccountDto() {
		super();
	}

	public AccountDto(Long accountNumber, String accountType, String branchAddress, Long customer_id) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchAddress = branchAddress;
		this.customer_id = customer_id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

}
