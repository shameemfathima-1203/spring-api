package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.model.User;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUser")
	public ResponseEntity<List<UserModel>>getUser(){
		return ResponseEntity.status(200).body(userService.getUser());
	}
	 
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserModel user){
	boolean dataSaved =userService.addUser(user);
	if(dataSaved)
	{
		return ResponseEntity.status(200).body("Employee added successfully");
	}
	else {
		return ResponseEntity.status(404).body("Something went wrong!");
	}
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<String>updateUser(@RequestParam int eid,@RequestBody UserModel user){
		boolean userData=userService.updateUser(eid,user);
		if(userData) {
			return ResponseEntity.status(200).body("Employee updated succesfully");
			
		}else {
			return ResponseEntity.status(404).body("No record found");
		}
	}
	
	@DeleteMapping("/deleteUser/{eid}")
	public ResponseEntity<String>deleteUser(@PathVariable int eid){
		boolean userDeleted=userService.deleteUser(eid);
		if(userDeleted) {
			return ResponseEntity.status(200).body("Employee Deleted succesfully");
		}else {
			return ResponseEntity.status(200).body("No record found");
		}
		
	}
}
