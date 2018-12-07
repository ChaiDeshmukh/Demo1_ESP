package com.sjsu.esp.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activities")
public class Activities {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String muscle;
	private String exercise;
	private String time;
	private String calories;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getCalories() {
		return calories;
	}
	
	public void setCalories(String calories) {
		this.calories = calories;
	}
}