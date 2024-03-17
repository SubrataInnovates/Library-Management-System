package com.library.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Author;
import com.library.entities.Book;
import com.library.exception.InvalidPageCountException;
import com.library.repository.AuthorRepository;
import com.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public String addBook(Book book) throws Exception
	{
		if(book.getNoOfPages()<=0)
		{
			
			throw new InvalidPageCountException("No of pages entered is wrong !!");
		}
		Book save = bookRepository.save(book);
		
		
		return "Book has been saved to DB"+save;
	}

	@Override
	public String associateBookAndAuthor(Integer bookId, Integer authorId) throws Exception 
	{
	    Optional<Book> bookOptional = bookRepository.findById(bookId);
	    if (bookOptional.isEmpty()) {
	        throw new Exception("Invalid book id !! try another one !!");
	    }
	    Book book = bookOptional.get();

	    Optional<Author> authorOptional = authorRepository.findById(authorId);
	    if (authorOptional.isEmpty()) {
	        throw new Exception("Invalid author id !! try another one !!"); 
	    }
	    Author author = authorOptional.get();

	    book.setAuthor(author);
	    author.setNoOfBooks(author.getNoOfBooks() + 1);

	    bookRepository.save(book);
	    authorRepository.save(author);

	    return "Book and Author have been associated";
	}

	@Override
	public List<Book> findBooksByAuthor(Integer authorId)
	{
		List<Book> books = bookRepository.findAll();
		List<Book> ansList=new ArrayList<>();
		
		for(Book book:books)
		{
			if(book.getAuthor().getAuthorId().equals(authorId))
			{
				ansList.add(book);
			}
		}
		
		return ansList;
	}
	

}
