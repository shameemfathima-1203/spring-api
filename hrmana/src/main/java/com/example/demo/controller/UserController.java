package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

import com.example.demo.model.Hr;
import com.example.demo.service.HrService;


@RestController
@RequestMapping("/api/v1/hrman")
public class UserController {
	
	@Autowired
	private HrService hrService;
	
	@GetMapping("/getUser")
	public ResponseEntity<List<Hr>>getUser(){
		return ResponseEntity.status(200).body(hrService.getUser());
	}
	
	@GetMapping("/sortAllUser")
	public Page<Hr> getAllUser(
				@RequestParam(defaultValue = "1") int page, 
				@RequestParam(defaultValue = "1") int size,
				@RequestParam(defaultValue = "noOfDept") String sortField,
				@RequestParam(defaultValue = "asc") String sortOrder
			){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortField));
		return hrService.getAllUser(pageRequest);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<String>addUser(@RequestBody Hr hr){
		boolean dataSaved= hrService.adduser(hr);
		if(dataSaved) {
			return ResponseEntity.status(200).body("Enquiry submitted successfully");
		}
		else {
			return ResponseEntity.status(404).body("Something went wrong");
		}
		
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String>updateuser(@PathVariable Long id,@RequestBody Hr hr){
	boolean userData=hrService.updateuser(id,hr);
	if(userData) {
		return ResponseEntity.status(200).body("Enquiry updated successfully");
		
	}
	else {
		return ResponseEntity.status(404).body("not updated");
	}
	}
	@PutMapping("/updateByQuery/{noOfPersons}/{id}")
	public ResponseEntity<Integer> updateUserQuery(@PathVariable int noOfPersons,@PathVariable int id){
		return ResponseEntity.status(200).body(hrService.updateUserQuery(noOfPersons,id));
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable Long id){
		boolean userDeleted=hrService.deleteUser(id);
		if(userDeleted) {
			return ResponseEntity.status(200).body("employee deleted successfully");
		}
		else {
			return ResponseEntity.status(404).body("not deleted");
		}
	}
	
	@DeleteMapping("/deleteByQuery/{id}")
	public int deleteUserQuery(@PathVariable int id) {
		 return hrService.deleteUserQuery(id);
	}
}