package com.example.demo.userserviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import jakarta.transaction.Transactional;

	
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean addUser(UserModel user) {
		
		boolean userExists = userRepository.existsByEmail(user.getEmail());
		if(!userExists) {
			userRepository.save(user);
			return true;
		}else {
			return false;
		}
}
@Override
public List<UserModel>getUser(){
	return userRepository.findAll();
}
	@Override
	public boolean updateUser(int id,UserModel user) {
//		userRepository.saveAndFlush(user);
		Optional<UserModel> existingUserOptional=userRepository.findById(id);
		if(existingUserOptional.isPresent()){
		UserModel userExists=existingUserOptional.get();
		userExists.setName(user.getName());
		userExists.setEmail(user.getEmail());
		userExists.setPassword(user.getPassword());
		userExists.setPost(user.getPost());
		userExists.setSalary(user.getSalary());
		userRepository.save(userExists);
		return true;
	}else {
		return false;
	}
	}
	@Override
	public boolean updateUse(UserModel user) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteUser(int eid) {
		// TODO Auto-generated method stub
		Optional<UserModel>existingUserOptional=userRepository.findById(eid);
		if(existingUserOptional.isPresent()) {
		userRepository.deleteById(eid);
		return true;
	}
		return false;
	}
}