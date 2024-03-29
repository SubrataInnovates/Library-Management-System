package com.library.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.services.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController
{
	@Autowired
	private TransactionService transactionService;
	
	private static final Logger log=LoggerFactory.getLogger(TransactionController.class);
	
	@PutMapping("/issueBook")
	public ResponseEntity issueBook(@RequestParam("cardId") Integer cardId,@RequestParam("bookId") Integer bookId)
	{
		try 
		{
			String issueBook = transactionService.issueBook(bookId, cardId);
			log.info("Book is issued : {} "+issueBook);
			return new ResponseEntity("Issued books in the db ",HttpStatus.OK);
			
		}
		catch (Exception e)
		{
			log.error("Error in issued books : {} "+e.getMessage());
			return new ResponseEntity(e.getStackTrace(),HttpStatus.BAD_REQUEST);
		}
	}

}
