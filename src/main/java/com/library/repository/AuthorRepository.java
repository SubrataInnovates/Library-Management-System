package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer>
{

}
