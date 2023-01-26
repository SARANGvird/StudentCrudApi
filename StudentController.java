package com.shivila.boot.controllr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.shivila.boot.model.Student;

import com.shivila.boot.service.IStudentService;
@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private IStudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<String>
	saveEmployee(@RequestBody Student student)
	{
		Integer id=service.saveStudent(student);
		return new ResponseEntity<String>("Employee  '"+id+"'saved",HttpStatus.OK);
	
	}
	@GetMapping("/all")
	public ResponseEntity<List<Student>>getAllStudent(){
		List<Student>list=service.getAllStudent();
		return new ResponseEntity<List<Student>> (list,HttpStatus.OK);
	}
	@GetMapping("/One/{id}")
	public ResponseEntity<Student> getOneStudent(
			@PathVariable Integer id
			){
		Student student=service.getOneStudent(id);
		return new ResponseEntity<Student>(student ,HttpStatus.OK);
	}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteStudent(
			@PathVariable Integer id
			){
		service.deleteStudent(id);
		return new ResponseEntity<String>("employee '"+id+"' Deleted",HttpStatus.OK);
	}
	@PutMapping("/modify/{id}")
	public ResponseEntity<String>updateEmployee(
			@PathVariable Integer id,
			@RequestBody Student student
			){
	Student db= service.getOneStudent(id);
	db.setStudentName(student.getStudentName());
	db.setStudentfees(student.getStudentfees());
	db.setStudentCourse(student.getStudentCourse());
	
	service.saveStudent(db);
	return new ResponseEntity<String>("Student '"+id+"' Updated",HttpStatus.OK);
}
}
