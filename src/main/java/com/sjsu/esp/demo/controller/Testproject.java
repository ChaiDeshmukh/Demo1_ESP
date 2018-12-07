package com.sjsu.esp.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Testproject {
	
	@ExceptionHandler(Exception.class)
    public String handleSQLException(HttpServletRequest request, Exception ex){
        System.out.println("SQLException Occured:: URL="+request.getRequestURL());
        ex.printStackTrace();
        return "database_error";
    }
	

}
