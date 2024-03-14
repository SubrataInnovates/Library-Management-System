package com.library.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.entities.Book;
import com.library.services.BookService;

@RestController
@RequestMapping("/book")
public class BookController 
{
	@Autowired
	private BookService bookService;
	
	private static final Logger logger=LoggerFactory.getLogger(BookController.class);
	@PostMapping("/add")
	public ResponseEntity addBook(@RequestBody Book book)
	{
		try {
			String addBook = bookService.addBook(book);
			return new ResponseEntity(addBook,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		
	}
	@PutMapping("/associateBookAndAuthor")
	public ResponseEntity associatedBookAndAuthor(@RequestParam ("bookId")Integer bookId,@RequestParam("authorId")Integer authorId)
	{
		String associateBookAndAuthor = bookService.associateBookAndAuthor(bookId, authorId);
		logger.info("Book and author have been associated : {} "+associateBookAndAuthor);
		return new ResponseEntity(associateBookAndAuthor,HttpStatus.OK);
	}
	@GetMapping("/getBooksByAuthor/{authorId}") // Corrected path variable syntax
    public List<Book> getBooksByAuthor(@PathVariable("authorId") Integer authorId) { // Use @PathVariable to access the path variable
        List<Book> books = bookService.findBooksByAuthor(authorId);
        logger.info("Getting books by author : {} ", books); // Corrected logging syntax
        return books;
    }
}
