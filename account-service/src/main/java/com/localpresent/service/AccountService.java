package com.localpresent.service;

import com.localpresent.domain.Account;
import com.localpresent.domain.User;

public interface AccountService {
	Account findByName(String accountName);
	
	Account create(User user);
	
	void saveChanges(String name, Account update);
}
