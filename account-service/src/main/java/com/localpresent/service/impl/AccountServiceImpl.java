package com.localpresent.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.localpresent.client.AuthServiceClient;
import com.localpresent.domain.Account;
import com.localpresent.domain.Currency;
import com.localpresent.domain.Saving;
import com.localpresent.domain.User;
import com.localpresent.repository.AccountRepository;
import com.localpresent.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AuthServiceClient authClient;
	
	@Override
	public Account findByName(String accountName) {
		Assert.hasLength(accountName);
		return accountRepository.findByName(accountName);
	}

	@Override
	public Account create(User user) {
		Account accountExist = accountRepository.findByName(user.getUsername());
		Assert.isNull(accountExist, "account already exists: " + user.getUsername());
		
		authClient.createUser(user);
		
		Saving saving = new Saving();
		
		saving.setAmount(new BigDecimal(0));
		saving.setCurrency(Currency.getDefault());
		saving.setInterest(new BigDecimal(0));
		saving.setDeposit(false);
		saving.setCapitalization(false);
		
		Account account = new Account();
		account.setName(user.getUsername());
		account.setLastSeen(new Date());
		account.setSaving(saving);
				
		accountRepository.save(account);
		
		log.info("new account has been created: " + account.getName());
		return account;
	}

	@Override
	public void saveChanges(String name, Account update) {
		Account account = accountRepository.findByName(name);
		Assert.isNull(account, "can't find account with name: " + name);
		
		account.setIncomes(update.getIncomes());
		account.setExpences(update.getExpences());
		account.setSaving(update.getSaving());
		account.setNote(update.getNote());
		account.setLastSeen(new Date());
		
		log.debug("Account {} changes has been saved", name);
		
	}

}
