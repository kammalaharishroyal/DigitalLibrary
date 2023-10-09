package com.harish.dl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harish.dl.Exceptions.UserNotFoundException;
import com.harish.dl.entity.AuthorEntity;
import com.harish.dl.models.AuthorEntityRequestModel;
import com.harish.dl.models.AuthorEntityResponseModel;
import com.harish.dl.service.impl.AuthorServiceImpl;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/author/")
public class AuthorController {
	
	@Autowired
	private AuthorServiceImpl asi;
	@GetMapping("")
	public String testApi() {
		return "authorApi is working...";
	}
	
	@PostMapping("create")
	public AuthorEntity create(@RequestBody @Valid AuthorEntity a) {
		return asi.create(a);
	}
	@PutMapping("update")
	public AuthorEntity update(@RequestBody AuthorEntity a) {
		return asi.update(a);
	}
	
	@GetMapping("get/{id}")
	public AuthorEntity getById(@PathVariable int id) throws UserNotFoundException {
		return asi.getById(id);
	}
	@GetMapping("getall")
	public List<AuthorEntity> getAll() {
		return asi.getAll();
	}
	

}
