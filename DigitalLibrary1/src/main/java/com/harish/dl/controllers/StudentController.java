package com.harish.dl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harish.dl.Exceptions.UserNotFoundException;
import com.harish.dl.entity.StudentEntity;
import com.harish.dl.models.StudentEntityRequestModel;
import com.harish.dl.service.impl.StudentServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/student/")
public class StudentController {
	@Autowired
	private StudentServiceImpl ss;
	@GetMapping("/")
	public String testApi() {
		
		return "testapi working";
	}
	@PostMapping("create")
	public StudentEntity create(@RequestBody StudentEntity sm ) {
		
		//(generatedId,sm.getName(),sm.getAge(),sm.getEmail(),sm.getPhone(),sm.getCountry(),sm.getCardId());
		
		
		return ss.create(sm);
	}
	@PutMapping("update")
	private StudentEntity updateStudent(@RequestBody StudentEntity s) {
		System.out.println("in update mapping :"+s);
		return ss.updateStudent(s);	
	}
	@GetMapping("getall")
	public List<StudentEntity> gettAll(){
		return ss.getAll();
	}
	
	@GetMapping("get/{id}")
	public StudentEntity gettById(@PathVariable int id)throws UserNotFoundException{
		return ss.getById(id);
	}
	@DeleteMapping("delete/{id}")
	public String deletebyId(@PathVariable int id) {
		return ss.deleteById(id);
	}
}
