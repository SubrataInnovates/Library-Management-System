package com.library.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.services.CardService;

@RestController
@RequestMapping("/card")

public class CardController 
{
	private static final Logger logger=LoggerFactory.getLogger(CardController.class);
	@Autowired
	private CardService cardService;
	@PostMapping("/generateCard")
	public ResponseEntity addCard()
	{
		String generateCard = cardService.generateCard();
		logger.info("Card is created :{}"+generateCard);
		
		return new ResponseEntity(generateCard,HttpStatus.OK);
		
	}

}
