package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entities.Book;

public interface BookRepository extends JpaRepository<Book,Integer>
{

}
