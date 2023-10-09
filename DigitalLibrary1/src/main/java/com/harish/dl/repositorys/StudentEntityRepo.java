package com.harish.dl.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.dl.entity.StudentEntity;

public interface StudentEntityRepo extends JpaRepository<StudentEntity, Integer> {

}
