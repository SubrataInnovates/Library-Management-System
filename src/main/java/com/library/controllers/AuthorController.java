package com.library.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity addAuthor(@RequestBody Author author)
	{
		String addAuthor = authorService.addAuthor(author);
		logger.info("Author is added in db :{}"+addAuthor);
		return new ResponseEntity(addAuthor,HttpStatus.OK);
	}
}
