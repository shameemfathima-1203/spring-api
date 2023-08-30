package com.example.demo.service.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hr;
import com.example.demo.repository.HrRepository;
import com.example.demo.service.HrService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class HrServiceImpl implements HrService {
    @Autowired
	private HrRepository hrRepository;
    
	@Override
	public boolean adduser(Hr hr) {
		// TODO Auto-generated method stub
		boolean userExists = hrRepository.existsByEmail(hr.getEmail());
		if(!userExists)
		{
			hrRepository.save(hr);
			return true;
		}else {
			
			return false;
		}
	}
	
	@Override
	public List<Hr> getUser() {
		// TODO Auto-generated method stub
		return hrRepository.findAll();
	}
	
	@Override
	public boolean updateuser(Long id,Hr hr) {
		
		Optional<Hr>existingUserOptional =hrRepository.findById(id);
		
		if(existingUserOptional.isPresent()) {
		Hr userExists=existingUserOptional.get();
		userExists.setName(hr.getName());
		userExists.setEmail(hr.getEmail());
		userExists.setNoOfPersons(hr.getNoOfPersons());
		userExists.setnoOfDept(hr.getnoOfDept());
		hrRepository.save(userExists);
		return true;
	}else {
		return false;
	}

}
	@Override
	public boolean deleteUser(Long id) {
		Optional<Hr>existingUserOptional=hrRepository.findById(id);
		if(existingUserOptional.isPresent()) {
			hrRepository.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Page<Hr> getAllUser(PageRequest pageRequest) {
		return hrRepository.findAll(pageRequest);
	}

	@Override
	public int updateUserQuery(int noOfPersons, int id) {
		return hrRepository.updateUserQuery(noOfPersons, id);
	}

	@Override
	public int deleteUserQuery(int id) {
		return hrRepository.deleteUserQuery(id);
	}

	
}
