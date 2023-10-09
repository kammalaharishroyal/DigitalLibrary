package com.harish.dl.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.harish.dl.Exceptions.UserNotFoundException;
import com.harish.dl.entity.BookEntity;
import com.harish.dl.entity.CardEntity;
import com.harish.dl.entity.TransactionEntity;
import com.harish.dl.repositorys.BookEntityRepo;
import com.harish.dl.repositorys.CardEntityRepo;
import com.harish.dl.repositorys.TransactionEntityRepo;
import com.harish.dl.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionEntityRepo tr;
	@Autowired
	private BookEntityRepo br;
	@Autowired
	private CardEntityRepo cr;
	@Value("${card.maxTransactions}")
	int maxCardTrans;
	@Value("${noOfAllowedDays}")
	int noOfAllowedDays;
	@Value("${fine}")
	int fine;
	public List<TransactionEntity> getAll() {
		return tr.findAll();
	}
	public TransactionEntity getById(int id) throws UserNotFoundException {
		if (tr.existsById(id)) {
			return tr.findById(id).get();
		}throw new UserNotFoundException("Transaction Not Found with id  "+id);
	}
	public TransactionEntity issueBook(int bid, int cid) throws UserNotFoundException {
		TransactionEntity t = null;// =null;//=tr.save(new Transaction());
		BookEntity b;
		if (br.existsById(bid)) {
			b = br.findById(bid).get();
			if (b.getStatus()) {// If the book is available--checked

				//System.out.println("book is avilable to take");
				// check card/student active or not

				// if all are true issues book
				// create new transaction
				//
				/*
				 * Kafka: Drop a kafka message for an email to be sent to the user, email Id has
				 * to be passed with the details of book issued and the last date of returning
				 * the book.
				 */
				// If any of the above return an error, insert a transaction as failure.
//			System.out.println(btr.checkNoTransaction(bid));
				if (tr.countNoOfCardTrans(cid) < maxCardTrans) {// card can have Atmost 3transactions--checked
					//System.out.println("card no of transactions:" + tr.countNoOfCardTrans(cid));
					Optional<CardEntity> ce = cr.findById(cid);
					if (ce.isEmpty()) {
						throw new UserNotFoundException("card Id:"+cid+" doesn't exists");
					} else {
						t = tr.save(new TransactionEntity());
						t.setIssued(true);
						t.setReturned(false);
						t.setCreatedOn(t.getCreatedOn());
						t.setFineAmount(t.getFineAmount());
						t.setBookDueDate(t.getBookDueDate());
						t.setBook(b);
						t.setCard(ce.get());
						b.setStatus(false);
						br.save(b);
						tr.save(t);
					}

				} else {

					throw new UserNotFoundException("Transaction Limit Exceded,cardId "+cid+"\n no of transactions:"+tr.countNoOfCardTrans(cid)+"\n Max Number Of Allowed Transactions");
				}
			} else {
				throw new UserNotFoundException("book is taken by someone ,bookId: "+bid);

			}
		} else {
			throw new UserNotFoundException("book Not available  "+bid);
		}
		return t;
	}

	public TransactionEntity returnBook(int bid, int cid) throws UserNotFoundException {
		TransactionEntity t=null;
		// System.out.println("in fun");
		//System.out.println("count bid,cid combined trans"+tr.countTran(bid, cid, false));
		List<TransactionEntity> tss=tr.countTran(bid, cid, false);
		if(tss.size()<1) {
		//	System.out.println("No transactions exist with given book-id:"+bid+",cid:"+cid+" or book already returned");
			throw new UserNotFoundException("No transactions exist with given book-id:"+bid+",cid:"+cid);
		}
		else {
			
		//System.out.println("in fun: "+tss);
		 t= tr.findTransByBookCardIds(bid, cid, false);
		 LocalDate d1=t.getCreatedOn();
		 LocalDate d2=LocalDate.now();
		 int NoOfDays=countDays(d1, d2);
		 if(NoOfDays>noOfAllowedDays) {
			 System.out.println("Due date is exceded pay fine ampount of:"+fine);
		 }
		 System.out.println("No of days b/w:"+d1+","+d2+" is:"+NoOfDays);
		//System.out.println("in t:=" + t);
		BookEntity b = br.findById(bid).get();
		b.setStatus(true);
		br.save(b);
		t.setReturned(true);
		t.setReturnedOn(new TransactionEntity().getCreatedOn());
		tr.save(t);
		System.out.println(t);
		}
		return t;
	}
	public int countDays(LocalDate d1,LocalDate d2) {
		Period p=Period.between(d1, d2);
		return p.getDays();
	}
}
