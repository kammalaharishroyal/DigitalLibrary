package com.harish.dl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.dl.entity.AuthorEntity;

public interface AuthorEntityRepo extends JpaRepository<AuthorEntity, Integer> {

}
