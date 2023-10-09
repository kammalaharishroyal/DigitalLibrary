package com.harish.dl.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.harish.dl.entity.TransactionEntity;

public interface TransactionEntityRepo extends JpaRepository<TransactionEntity, Integer> {
	
	

	@Query(value = "select count(t.book_id) from transaction_entity t where t.book_id=:bid",nativeQuery = true)
	int existsByBookid_id(int bid);
	
	//@Query(value="select * from transaction_entity t where t.bookid_id=:bookid_id",nativeQuery = true)
//	TransactionEntity findByBookidId(int bookid_id);
	
	
	@Query(value="select count(t.book_id) from transaction_entity t where t.book_id=:bid",nativeQuery = true)
	int countById(int bid);
	
	@Query(value="select * from transaction_entity t where t.book_id=:bid and t.card_id=:cid and t.is_returned=:st ",nativeQuery = true)
	TransactionEntity findTransByBookCardIds(int bid,int cid,boolean st);
	
	@Query(value="select count(*) from transaction_entity t where card_id=:cid",nativeQuery = true)
	int countNoOfCardTrans(int cid);
	@Query(value="select * from transaction_entity t where t.book_id=:bid and t.card_id=:cid and t.is_returned=:b ",nativeQuery = true)
	List<TransactionEntity> countTran(int bid, int cid, boolean b);
	
	
}
