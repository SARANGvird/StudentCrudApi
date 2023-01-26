package com.shivila.boot.service;

import java.util.List;


import com.shivila.boot.model.Student;

public interface IStudentService {
	Integer	saveStudent(Student s);
	List<Student>	getAllEmployee();
	  Student getStudent(Integer id);
	  void deleteStudent(Integer id);
	  void updateStudent(Student s);
	Student getOneStudent(Integer id);
	List<Student> getAllStudent();
}
