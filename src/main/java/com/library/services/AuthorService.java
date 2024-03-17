package com.library.services;

import com.library.entities.Author;

public interface AuthorService 
{
	public String addAuthor(Author author);
	public Author getAuthorWithMaxBooks();

}
