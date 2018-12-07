package com.sjsu.esp.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sjsu.esp.demo.model.Activities;
import com.sjsu.esp.demo.model.IdealWeight;
import com.sjsu.esp.demo.model.User;

@Repository
public interface NativeRepository {
	
	public User getUserInfo(String username);
	public IdealWeight getIdealWeight(String height, String gender);
	public List<Activities> getActivities(String muscle);
	public List<Activities> getAllActivities();
	int clearRecords(int userId);
}
