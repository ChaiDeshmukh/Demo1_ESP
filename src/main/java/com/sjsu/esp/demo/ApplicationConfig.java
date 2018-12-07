package com.sjsu.esp.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sjsu.esp.demo.repository.impl.NativeRepositoryImpl;
import com.sjsu.esp.demo.services.impl.UserServiceImpl;

@Configuration
public class ApplicationConfig {
    @Bean
    public UserServiceImpl userServiceImpl() {
    	 	return new UserServiceImpl();
    }
    
    @Bean
    public NativeRepositoryImpl NativeDBRepositoryImpl() {
    	 	return new NativeRepositoryImpl();
    }
}
