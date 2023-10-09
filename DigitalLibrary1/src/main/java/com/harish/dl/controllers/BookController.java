package com.harish.dl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harish.dl.Exceptions.UserNotFoundException;
import com.harish.dl.entity.BookEntity;
import com.harish.dl.models.BookEntityRequestModel;
import com.harish.dl.models.BookEntityResponseModel;
import com.harish.dl.service.impl.BookServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/book/")
public class BookController {
	@Autowired
	private BookServiceImpl bsi;
	@GetMapping("")
	public String testApi() {
		return "bookApi is working...";
	}
	@PostMapping("create")
	public BookEntity create(@RequestBody @Valid BookEntity b)  {
//		BookEntity b1=bsi.create(b);
		
		return  bsi.create(b);
	}
	@GetMapping("getall")
	public List<BookEntity> getAll(){
		return bsi.getAll();
	}
	@GetMapping("get/{id}")
	public BookEntity getById(@PathVariable int id)throws UserNotFoundException{
		return bsi.getById(id);
	}
	@PutMapping("update")
	public BookEntity update(@RequestBody BookEntity b){
		return bsi.update(b);
	}

}
