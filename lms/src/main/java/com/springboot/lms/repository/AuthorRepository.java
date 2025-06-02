package com.springboot.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lms.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
