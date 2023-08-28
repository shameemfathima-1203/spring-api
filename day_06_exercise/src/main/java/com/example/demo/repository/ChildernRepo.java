package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ChildernModel;

@Repository
public interface ChildernRepo extends JpaRepository<ChildernModel, Integer>{

}
