package com.harish.dl.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.harish.dl.Exceptions.UserNotFoundException;

@RestControllerAdvice
public class AppExcep {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleError(MethodArgumentNotValidException e){
		Map<String,String> m=new HashMap<>();
		e.getBindingResult().getAllErrors().forEach(t ->{
			m.put(t.getCode(),t.getDefaultMessage());
		});
	//	m.put(, null)
		return m;
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleBusinessExc(UserNotFoundException e){
		Map<String,String> m=new HashMap<>();
		m.put("errorMessage", e.getMessage());
		return m;
	}

}
