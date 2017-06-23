package com.localpresent.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.localpresent.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>{
	Account findByName(String accountName);
}
