package com.shivila.boot.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivila.boot.exceptn.StudentNotFoundException;
import com.shivila.boot.model.Student;
import com.shivila.boot.service.IStudentService;
import com.shivila.boot.studentRepo.StudentRepo;

@Service
public class StudentServiceImpl implements IStudentService {


	@Autowired
	private StudentRepo repos;
	
	@Override
	public Integer saveStudent(Student s) {
		Integer id=repos.save(s).getStudentId();
		return id;
		
	}

	@Override
	public List<Student> getAllEmployee() {
		List<Student> list=repos.findAll();
		return list;
	}

	@Override
	public Student getStudent(Integer id) {
		 Optional<Student>opt= repos.findById(id);
			Student std= opt.orElseThrow(()-> new StudentNotFoundException("Student Not Exist "));
			 return std;
	}

	@Override
	public void deleteStudent(Integer id) {
		Student std=getOneStudent(id); 
		repos.delete(std);
	}

	@Override
	public void updateStudent(Student s) {
		repos.save(s);
		
	}

	@Override
	public Student getOneStudent(Integer id) {
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

}
