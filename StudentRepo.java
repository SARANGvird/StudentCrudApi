package com.shivila.boot.studentRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivila.boot.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
