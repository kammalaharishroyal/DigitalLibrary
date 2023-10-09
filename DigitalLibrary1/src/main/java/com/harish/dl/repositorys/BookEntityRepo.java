package com.harish.dl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.dl.entity.BookEntity;

public interface BookEntityRepo extends JpaRepository<BookEntity, Integer> {

}
