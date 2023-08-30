package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="enquiry")
public class Enquiry {
	@Id
	@GeneratedValue
	private int id;
	private int enquiryNum;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="enquiry_id",referencedColumnName="id")
	private List<Employee> employee;
	
	public Enquiry() {
		super();
	}
	public Enquiry(int id, int enquiryNum) {
		super();
		this.id = id;
		this.enquiryNum = enquiryNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEnquiryNum() {
		return enquiryNum;
	}
	public void setEnquiryNum(int enquiryNum) {
		this.enquiryNum = enquiryNum;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	

}
