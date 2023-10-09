package com.harish.dl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.dl.entity.CardEntity;

public interface CardEntityRepo extends JpaRepository<CardEntity, Integer> {

}
