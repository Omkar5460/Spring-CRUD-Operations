package com.springcrud.SpringCrud.controller;
import com.springcrud.SpringCrud.entity.StudentInfo;
import com.springcrud.SpringCrud.exception.SomethingIsMissingException;
import com.springcrud.SpringCrud.repository.StudentRepository;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
		//get all students
		@GetMapping
		public List<StudentInfo> getAllStudents(){
			return this.studentRepo.findAll();
			
		}
		
		//Get student by roll API
		@GetMapping("/{roll}")
		public StudentInfo getStudentByRollno(@PathVariable(value ="roll") int rollno)
		{
			return this.studentRepo.findById(rollno).orElseThrow(()-> new SomethingIsMissingException("student Not Found "+ rollno));
		}
		
		
		//create student API
		@PostMapping
		public StudentInfo createUser(@RequestBody StudentInfo student)
		{
			return this.studentRepo.save(student);
		}
		
		
		//Update student
		@PutMapping("/{rollno}")
		public StudentInfo updateUser(@RequestBody StudentInfo student, @PathVariable(value = "rollno") int rollno)
		{
			
			StudentInfo ExistingStudent = this.studentRepo.findById(rollno).orElseThrow(()-> new SomethingIsMissingException("Student Not Found "+ rollno));
			ExistingStudent.setName(student.getName());
			ExistingStudent.setCity(student.getCity());
			return this.studentRepo.save(ExistingStudent);
			
		}
		
		
		//Delete Student rollno
		
		@DeleteMapping("/{roll}")
		public ResponseEntity<StudentInfo> deleteStudent(@PathVariable ("roll") int rollno)
		{
			StudentInfo ExistingStudent = this.studentRepo.findById(rollno).orElseThrow(()-> new SomethingIsMissingException("Student Not Found "+ rollno));
			this.studentRepo.delete(ExistingStudent);
			return ResponseEntity.ok().build();
		}
		
		
}
