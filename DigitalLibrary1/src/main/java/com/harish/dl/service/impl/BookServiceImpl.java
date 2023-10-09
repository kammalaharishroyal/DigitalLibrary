package com.harish.dl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.dl.Exceptions.UserNotFoundException;
import com.harish.dl.entity.BookEntity;
import com.harish.dl.models.BookEntityRequestModel;
import com.harish.dl.models.BookEntityResponseModel;
import com.harish.dl.repositorys.BookEntityRepo;
import com.harish.dl.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookEntityRepo br;
	public BookEntity create(BookEntity b) {
		return br.save(b); 
	}

	public List<BookEntity> getAll() {
		
		return br.findAll();
	}

	public BookEntity getById(int id) throws UserNotFoundException {
		if(br.existsById(id)) {
			return br.findById(id).get();
		}
		throw new UserNotFoundException("User Not Found with id  "+id);
	}

	public BookEntity update(BookEntity b) {
		// TODO Auto-generated method stub
		return br.save(b);
	}

	
}
