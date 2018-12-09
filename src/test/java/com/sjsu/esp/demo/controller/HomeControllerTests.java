package com.sjsu.esp.demo.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.sjsu.esp.demo.model.Activities;
import com.sjsu.esp.demo.services.impl.UserServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value=HomeController.class,secure = false)
public class HomeControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserServiceImpl userServiceImpl;
	
	
	@Test //@Ignore
	public void testGetActivities() throws Exception {

		String URI = "/showactivities";
		Mockito.when(userServiceImpl.getActivities(Mockito.anyString())).thenReturn(getActivities());
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test //@Ignore
	public void testCalculateCaloriesBurnt() throws Exception {
		
		String URI = "/calculatecaloriesburnt";
		Mockito.when(userServiceImpl.calculateCaloriesBurnt(Mockito.anyString())).thenReturn(Mockito.anyDouble());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	public List<Activities> getActivities(){
		
		List<Activities> list = new ArrayList<Activities>();
		Activities activity1 = new Activities();
		activity1.setId(000);
		activity1.setMuscle("x");
		activity1.setTime("a");
		activity1.setExercise("b");
		activity1.setCalories("c");
		
		Activities activity2 = new Activities();
		activity2.setId(000);
		activity2.setMuscle("y");
		activity2.setTime("b");
		activity2.setExercise("c");
		activity2.setCalories("d");
		
		Activities activity3 = new Activities();
		activity3.setId(000);
		activity3.setMuscle("z");
		activity3.setTime("c");
		activity3.setExercise("d");
		activity3.setCalories("e");
		
		list.add(activity1);
		list.add(activity2);
		list.add(activity3);
		return list;
	}
}
