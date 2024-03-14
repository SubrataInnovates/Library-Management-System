package com.library.services;

import java.util.List;

import com.library.entities.Book;


public interface BookService 
{
	String addBook(Book book) throws Exception;
	public String associateBookAndAuthor(Integer bookId,Integer authorId);
	public List<Book> findBooksByAuthor(Integer authorId);

}
