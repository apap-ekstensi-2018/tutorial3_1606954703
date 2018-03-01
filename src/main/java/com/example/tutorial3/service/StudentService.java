package com.example.tutorial3.service;

import java.util.List;

import com.example.tutorial3.model.StudentModel;

public interface StudentService {
	StudentModel selectStudent(String npm); //melihat data Student berdasarkan NPM-nya
	
	void deleteStudent(String npm); 		//delete student (Latihan)
	
	List<StudentModel> selectAllStudents(); //melihat seluruh data Student
	
	void addStudent(StudentModel student);	//menambahkan Student baru.
}

