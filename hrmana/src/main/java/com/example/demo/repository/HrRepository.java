package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Hr;



import jakarta.transaction.Transactional;



public interface HrRepository extends JpaRepository<Hr,Integer>{

	boolean existsByEmail(String email);
	Optional<Hr>findById(Long id);
	Optional<Hr>deleteById(Long id);
	
	@Modifying
	@Transactional
	@Query("update Hr t set t.noOfPersons = :noOfPersons where t.id=:id")
	int updateUserQuery(@Param("noOfPersons") int noOfPersons,@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value="delete from hr where id = ?1" ,nativeQuery=true)
	int deleteUserQuery(int id);

}
