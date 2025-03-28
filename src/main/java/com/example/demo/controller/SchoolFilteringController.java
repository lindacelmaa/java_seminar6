package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Grade;
import com.example.demo.service.ISchoolFilteringService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/school/filtering")
public class SchoolFilteringController {

	@Autowired
	private ISchoolFilteringService schoolFiltService;
	
	@GetMapping("/grades/student/{id}")//localhost:8080/school/filtering/grades/student/1
	public String getControllerGradesByStudent(@PathVariable(name="id") long id, Model model) {
		System.out.println("kuku");
		try {
			ArrayList<Grade> filteredGrades = schoolFiltService.selectGradesByStudentId(id);
			model.addAttribute("package", filteredGrades);
			return "show-grades";
		}catch(Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error";
		}
		
	}
	@GetMapping("/courses/student/{id}")//localhost:8080/school/filtering/courses/student/1
	public String getControllerCoursesByStudent(@PathVariable(name = "id") long id, Model model) {
		try {
			ArrayList<Grade> filteredGrades = schoolFiltService.selectGradesByStudentId(id);
			return "show-courses";
		}catch(Exception e) {
			model.addAttribute("package", e.getMessage());
			return "show-error";
		}
	}
	
	
}
