package com.harish.dl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.dl.entity.UserEntity;

public interface UserEntityRepo extends JpaRepository<UserEntity, Integer> {

}
