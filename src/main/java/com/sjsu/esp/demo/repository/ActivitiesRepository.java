package com.sjsu.esp.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sjsu.esp.demo.model.Activities;


@Repository
public interface ActivitiesRepository extends CrudRepository<Activities, String>{

	
}
