package com.springcrud.SpringCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcrud.SpringCrud.entity.StudentInfo;

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Integer>{ //Bean class name and wrapper class of the data type of id
	
		
}
