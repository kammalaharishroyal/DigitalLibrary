package com.harish.dl.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harish.dl.Exceptions.UserNotFoundException;
import com.harish.dl.entity.TransactionEntity;
import com.harish.dl.service.impl.TransactionServiceImpl;

@RestController
@RequestMapping("/transact/")
public class TransactionController {
	@Autowired
	private TransactionServiceImpl ts;
	@GetMapping("")
	public String testApi() {
		return "transactApi is working...";
	}
	@GetMapping("getall")
	public List<TransactionEntity> getAll() {
		return ts.getAll();
	}
	@GetMapping("get/{id}")
	public TransactionEntity getById(@PathVariable int id) throws UserNotFoundException {
		return ts.getById(id);
	}
	@GetMapping("getbook/{bookId}/{cardId}")
	public TransactionEntity issueBook(@PathVariable int bookId,@PathVariable int cardId ) throws UserNotFoundException {
		//System.out.println("in issue book:"+bookId+","+cardId);
		return ts.issueBook(bookId,cardId);
	}
	@GetMapping("return/{bid}/{cid}")
	public TransactionEntity returnBook(@PathVariable int bid,@PathVariable int cid )throws UserNotFoundException {
		return ts.returnBook(bid,cid);
	}
}
