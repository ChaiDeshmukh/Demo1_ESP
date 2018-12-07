package com.sjsu.esp.demo.services;

import java.util.List;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Service;

import com.sjsu.esp.demo.model.Activities;
import com.sjsu.esp.demo.model.User;
@Service
public interface UserService {
	
	User createUser(String email) throws ValidationException;
	String idealWeight(String height, String gender);
	List<Activities> getActivities(String muscle);
	boolean addUserActivity(String email, String muscle, String exercise, String time);
	double calculateCaloriesBurnt(String email);
	void adminAddNewActivity(String muscle, String exercise, String time, String calories);
}
