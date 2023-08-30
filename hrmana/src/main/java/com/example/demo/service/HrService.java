package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.model.Hr;
public interface HrService {
	public boolean adduser(Hr hr);
	public List<Hr> getUser();
	public boolean updateuser(Long id, Hr hr);
	boolean deleteUser(Long id);
	public Page<Hr> getAllUser(PageRequest pageRequest);
	public int updateUserQuery(int noOfPersons, int id);
	public int deleteUserQuery(int id);

}
