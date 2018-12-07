package com.sjsu.esp.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sjsu.esp.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

	
}
