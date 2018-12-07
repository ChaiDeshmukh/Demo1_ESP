package com.sjsu.esp.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sjsu.esp.demo.model.UserActivity;

@Repository
public interface UserActivityRepository extends CrudRepository<UserActivity, String>{

	
}
