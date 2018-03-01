package com.example.tutorial3.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tutorial3.model.StudentModel;
import com.example.tutorial3.service.InMemoryStudentService;
import com.example.tutorial3.service.StudentService;

@Controller
public class StudentController {
	private final StudentService studentService;
	
	public StudentController() {
		studentService = new InMemoryStudentService();
	}
	
	@RequestMapping("/student/add") //menerima parameter name, npm, dan gpa dengan menggunakan request method GET
	public String add(@RequestParam(value = "npm", required = true) String npm,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "gpa", required = true) double gpa) {
		StudentModel student = new StudentModel(npm, name, gpa);
		studentService.addStudent(student);
		return "add";
	}
	
	@RequestMapping("/student/view") //melihat apakah data benar-benar tersimpan pada ArrayList
	public String view(Model model, @RequestParam(value = "npm", required = true) String npm) {
		StudentModel student = studentService.selectStudent(npm);
		model.addAttribute("student", student);
		return "view";
	}
	
	//Latihan nomor 1
	@RequestMapping(value = {"/student/view/", "/student/view/{npm}"})
	public String greetingPath(@PathVariable String npm, Model model) {
		StudentModel student = studentService.selectStudent(npm);
		if(student != null) {
			if (student.getNpm().equals(npm)) {	
				model.addAttribute("student", student);
				return "view";
			}else {			
				model.addAttribute("npm", "apap");
				return "viewOther";
			}
		}else {
			return "viewOther";
		}				
	}
	
	//Latihan nomor 2
	@RequestMapping(value = {"/student/delete/", "/student/delete/{npm}"})
	public String delete(@PathVariable String npm, Model model) {	
		StudentModel student = studentService.selectStudent(npm);
		if(student != null){
			if (student.getNpm().equals(npm)) {	
				studentService.deleteStudent(npm);
				return "delete";
			}else {			
				model.addAttribute("npm", "apap");
				return "deleteOther";
			}
		}else {
			return "deleteOther";
		}
				
	}
	
	@RequestMapping("/student/viewall")
	public String viewAll(Model model) {
		List<StudentModel> students = studentService.selectAllStudents();
		model.addAttribute("students", students);
		return "viewall";		
	}
}
