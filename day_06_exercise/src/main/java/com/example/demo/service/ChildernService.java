package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildernModel;
import com.example.demo.repository.ChildernRepo;

@Service
public class ChildernService {
	@Autowired
	ChildernRepo cr;
	public ChildernModel addinfo(ChildernModel s) {
		return cr.save(s);
	}
	public List<ChildernModel> show(){
		return cr.findAll();
	}
	public List<ChildernModel> showinfo(String s){
		return cr.findAll(Sort.by(Sort.Direction.ASC,s));
	}
	public List<ChildernModel> getbypage(int pageno,int pagesize){
		Page<ChildernModel> p = cr.findAll(PageRequest.of(pageno,pagesize));
		return p.getContent();
	}
	public void deleteinfo(int id) {
		cr.deleteById(id);
	}
	public List<ChildernModel> showdetails(String s,int page,int pageSize){
		PageRequest pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, s));
        Page<ChildernModel> childrenPage = cr.findAll(pageable);
        return childrenPage.getContent();
	}
	
}
