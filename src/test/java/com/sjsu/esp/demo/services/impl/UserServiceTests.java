package com.sjsu.esp.demo.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.xml.bind.ValidationException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.sjsu.esp.demo.model.IdealWeight;
import com.sjsu.esp.demo.model.User;
import com.sjsu.esp.demo.model.UserActivity;
import com.sjsu.esp.demo.repository.ActivitiesRepository;
import com.sjsu.esp.demo.repository.NativeRepository;
import com.sjsu.esp.demo.repository.UserActivityRepository;
import com.sjsu.esp.demo.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@MockBean
	private UserRepository userRepository;

	@MockBean
	private NativeRepository nativeRepository;
	
	@MockBean
	private UserActivityRepository userActivityRepository;
	
	@MockBean
	private ActivitiesRepository activitiesRepository;
	
	@Test //@Ignore
	public void testCreateUser() throws ValidationException {
		
		User user = new User();
		user.setId(1);
		user.setEmail_id("a@a.com");
		user.setIs_admin("true");
		user.setPassword("pass");
		
		Mockito.when(userRepository.save(user)).thenReturn(null);
		assertEquals(userServiceImpl.createUser("a@A.com"), user);
	}
	
	@Test //@Ignore
	public void testIdealWeight() {
		
		IdealWeight iw = new IdealWeight();
		iw.setId(1);
		iw.setGender("male");
		iw.setHeight("5.10");
		iw.setWeight("50-70");
		Mockito.when(nativeRepository.getIdealWeight(Mockito.anyString(), Mockito.anyString())).thenReturn(iw);
		assertEquals(userServiceImpl.idealWeight("5.10", "male"), "50-70");
	}

	@Test //@Ignore
	public void testRecordUserActivity() {
		
		UserActivity ua = new UserActivity();
		ua.setId(1);
		ua.setMuscle("abb");
		ua.setExercise("pull");
		ua.setUserid(1);
		ua.setTime("time");
		ua.setCreatedtime(null);
		
		User user = new User();
		user.setId(1);
		user.setEmail_id("email@email.com");
		user.setIs_admin("false");
		user.setPassword("ppp");;
		
		Mockito.when(nativeRepository.getUserInfo("b@1.com")).thenReturn(user);
		Mockito.when(userActivityRepository.save(ua)).thenReturn(null);
		assertTrue(userServiceImpl.addUserActivity("abb", "pull", "thy", "20"));
	}
}