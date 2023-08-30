package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue
	private int id;
	private String place;
	private int ldays;
	private Long salary;
	private int eage;
	
	public Employee() {
		super();
	}
	public Employee(int id, String place, int ldays,Long salary,int eage) {
		super();
		this.id = id;
		this.place = place;
		this.ldays = ldays;
		this.salary = salary;
		this.eage=eage;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getDays() {
		return ldays;
	}
	public void setDays(int ldays) {
		this.ldays = ldays;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public int getEage() {
		return eage;
	}
	public void setEage(int eage) {
		this.eage = eage;
	}
	
}

