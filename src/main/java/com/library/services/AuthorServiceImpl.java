package com.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Author;
import com.library.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService
{
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public String addAuthor(Author author)
	{
		author.setNoOfBooks(0);
		Author save = authorRepository.save(author);
		
		return "Author is added in db "+save;
	}

	@Override
	public Author getAuthorWithMaxBooks()
	{
		List<Author> listOfAuthors = authorRepository.findAll();
		Author ansAuthor=null;
		int maxBooks=0;
		
		for(Author authors:listOfAuthors)
		{
			if(authors.getNoOfBooks()>maxBooks)
			{
				maxBooks=authors.getNoOfBooks();
				ansAuthor=authors;
			}
		}
		return ansAuthor;
		
		
	}
	
}
