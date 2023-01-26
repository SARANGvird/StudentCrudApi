package com.shivila.boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	  @Id
	     @GeneratedValue
		private Integer StudentId;
		private String StudentName;
		private  Double Studentfees;
		private String StudentCourse;
}
