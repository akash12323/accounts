package com.micro.account.dto.transformer;

import com.micro.account.dto.AccountDto;
import com.micro.account.entity.Accounts;

public class AccountMapper {

	public static AccountDto transformToAccountDto(Accounts account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setAccountType(account.getAccountType());
		accountDto.setBranchAddress(account.getBranchAddress());
		return accountDto;
	}
	
	public static Accounts transformToAccount(AccountDto accountDto) {
		Accounts account = new Accounts();
		account.setAccountNumber(accountDto.getAccountNumber());
		account.setAccountType(accountDto.getAccountType());
		account.setBranchAddress(accountDto.getBranchAddress());
		return account;
	}
}
