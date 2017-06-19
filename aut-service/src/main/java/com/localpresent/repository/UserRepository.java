package com.localpresent.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.localpresent.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

}
