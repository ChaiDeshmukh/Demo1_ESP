package com.sjsu.esp.demo.services.impl;

import java.sql.Timestamp;
import java.util.List;
import javax.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import com.sjsu.esp.demo.model.Activities;
import com.sjsu.esp.demo.model.IdealWeight;
import com.sjsu.esp.demo.model.User;
import com.sjsu.esp.demo.model.UserActivity;
import com.sjsu.esp.demo.repository.ActivitiesRepository;
import com.sjsu.esp.demo.repository.UserActivityRepository;
import com.sjsu.esp.demo.repository.UserRepository;
import com.sjsu.esp.demo.repository.impl.NativeRepositoryImpl;
import com.sjsu.esp.demo.services.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	NativeRepositoryImpl nativeRepositoryImpl;
	
	@Autowired
	UserActivityRepository userActivityRepository;
	
	@Autowired
	ActivitiesRepository activitiesRepository;
	
	public final String password = "okta";
	
	public User createUser(String email) throws ValidationException {
	
		if (!checkIfUserExists(email)) {
			User user = new User();
			user.setEmail_id(email);
			user.setPassword(password);
			user.setIs_admin("false");
			userRepository.save(user);
		}
		return nativeRepositoryImpl.getUserInfo(email);
	}
	
	public boolean checkIfUserExists(String email) {
		
		User user = nativeRepositoryImpl.getUserInfo(email);
		if (user != null) {
			if (user.getEmail_id() != null && user.getEmail_id().trim().equalsIgnoreCase(email.trim())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String idealWeight(String height, String gender) {
		
		IdealWeight idealWeight = nativeRepositoryImpl.getIdealWeight(height, gender);
		return idealWeight.getWeight();
	}

	@Override
	public List<Activities> getActivities(String muscle) {
		List<Activities> activities = nativeRepositoryImpl.getActivities(muscle);
		return activities;
	}

	@Override
	public boolean addUserActivity(String email, String muscle, String exercise, String time) {

		User userInfo = nativeRepositoryImpl.getUserInfo(email);
		
		try {
			UserActivity userActivity = new UserActivity();
			userActivity.setUserid(userInfo.getId());
			userActivity.setMuscle(muscle);
			userActivity.setExercise(exercise);
			userActivity.setTime(time);
			userActivity.setCreatedtime(new Timestamp(System.currentTimeMillis()));
			userActivityRepository.save(userActivity);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public double calculateCaloriesBurnt(String email) {
		
		double total_calories = 0;
		double calories = 0;
		
		//get user info
		User userInfo = nativeRepositoryImpl.getUserInfo(email);
		if (userInfo == null) {
			return total_calories;
		}
		
		//get user activities
		List<UserActivity> userActivities = nativeRepositoryImpl.getUserActivities(userInfo.getId());
		if (userActivities.size() == 0) {
			return total_calories;
		}
		
		//get all activities
		List<Activities> allActivities = nativeRepositoryImpl.getAllActivities();
		if (allActivities.size() == 0) {
			return total_calories;
		}
		
		for (UserActivity userActivity : userActivities) {
			for (Activities activities : allActivities) {
				if (activities.getExercise().trim().equalsIgnoreCase(userActivity.getExercise().trim())) {
					calories = Double.valueOf(activities.getCalories()) *  Integer.valueOf(userActivity.getTime());
					continue;
				}
			}
			total_calories = total_calories + calories;
		}
		
		//clear records from database
		nativeRepositoryImpl.clearRecords(userInfo.getId());
		
		return total_calories;
	}

	@Override
	public void adminAddNewActivity(String muscle, String exercise, String time, String calories) {
		
		Activities activities = new Activities();
		activities.setMuscle(muscle);
		activities.setExercise(exercise);
		activities.setTime(time);
		activities.setCalories(calories);
		activitiesRepository.save(activities);
	}
}