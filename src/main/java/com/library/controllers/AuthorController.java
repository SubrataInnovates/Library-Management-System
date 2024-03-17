package com.library.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entities.Author;
import com.library.services.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController
{
	@Autowired
	private AuthorService authorService;
	
	private static final Logger logger=LoggerFactory.getLogger(AuthorController.class);
	@PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody Author author) {
        try {
            String addAuthorResult = authorService.addAuthor(author);
            logger.info("Author is added in db: {}", addAuthorResult);
            return ResponseEntity.ok(addAuthorResult);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding author");
        }
    }
	
	@GetMapping("/getAuthorWithMaxBooks")
    public ResponseEntity<Author> getAuthorWithMaxBooks() {
        try {
            Author authorWithMaxBooks = authorService.getAuthorWithMaxBooks();
            if (authorWithMaxBooks != null) {
                return ResponseEntity.ok(authorWithMaxBooks);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            
            logger.error("An error occurred while retrieving author with max books: {}", e.getMessage());
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
