package com.example.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import com.example.tutorial3.model.StudentModel;


public class InMemoryStudentService implements StudentService{
	private static List<StudentModel> studentList = new ArrayList<StudentModel>(); //menyimpan seluruh data mahasiswa
	
	@Override
	public StudentModel selectStudent(String npm) {
		//Method ini menerima NPM mahasiswa dan mengembalikan object Student 
		//dengan NPM tersebut. Return null jika tidak ditemukan
		for (int i=0; i<studentList.size(); i++) {
			if (studentList.get(i).getNpm().equals(npm)) {
				return studentList.get(i);
			}
		}
		return null;
	} 
	
	//Latihan 
	@Override
	public void deleteStudent(String npm) {
		//Method ini menerima NPM mahasiswa dan mengembalikan object Student dengan NPM tersebut. Return null jika tidak ditemukan
		for (int i=0; i<studentList.size(); i++) {
			if (studentList.get(i).getNpm().equals(npm)) {
				studentList.remove(i);
			}
		}
	}
	
	@Override
	public List<StudentModel> selectAllStudents(){
		return studentList;
	}
	
	public void addStudent(StudentModel student) {
		studentList.add(student);
	}
}

