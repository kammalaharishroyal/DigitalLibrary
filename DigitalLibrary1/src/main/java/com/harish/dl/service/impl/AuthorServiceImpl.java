package com.harish.dl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.dl.Exceptions.UserNotFoundException;
import com.harish.dl.entity.AuthorEntity;
import com.harish.dl.models.AuthorEntityRequestModel;
import com.harish.dl.models.AuthorEntityResponseModel;
import com.harish.dl.repositorys.AuthorEntityRepo;
import com.harish.dl.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorEntityRepo ar;

	public AuthorEntity create(AuthorEntity a) {
		
//		 AuthorEntity a2=ar.save(new AuthorEntity());
//		 a2.setAge(a.getAge());
//		 a2.setCountry(a.getCountry());
//		 a2.setEmail(a.getEmail());
//		 a2.setName(a.getName());
//		 
//		 
//		// AuthorEntityResponseModel a1=new AuthorEntityResponseModel(a2.getId(),a2.getName(),a2.getEmail(),a2.getAge(),a2.getCountry());
		
		return ar.save(a);
	}


	public AuthorEntity update(AuthorEntity a) {
		
		return ar.save(a);
	}

	public AuthorEntity getById(int id) throws UserNotFoundException {
		if(ar.existsById(id)) {
			return ar.findById(id).get();
		}
		throw new UserNotFoundException("User Not Found with id  "+id);
		//System.out.println("id :"+id+" not exists");
		//return null;
	}

	public List<AuthorEntity> getAll() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	public String deleteById(int id) {
		
		if(ar.existsById(id)) {
			ar.deleteById(id);
			return id+" is deleted";
		}
		return "id doesn't exist";
	}

}
