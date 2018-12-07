package com.sjsu.esp.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdailyactivity")
public class UserActivity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int userid;
	private String muscle;
	private String exercise;
	private String time;
	private Timestamp createdtime;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getMuscle() {
		return muscle;
	}
	
	public void setMuscle(String muscle) {
		this.muscle = muscle;
	}
	
	public String getExercise() {
		return exercise;
	}
	
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public Timestamp getCreatedtime() {
		return createdtime;
	}
	
	public void setCreatedtime(Timestamp createdtime) {
		this.createdtime = createdtime;
	}
}