package com.library.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.CardStatus;
import com.library.entities.LibraryCard;
import com.library.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService
{
	@Autowired
	CardRepository cardRepository;

	@Override
	public String generateCard()
	{
		LibraryCard card = new LibraryCard();
		card.setCardStatus(CardStatus.NEW);
		card.setNoOfBooksIssued(0);
		Date expiryDate=new Date();
		
		card.setValidity(expiryDate);
		
		LibraryCard save = cardRepository.save(card);
		return "The card is generated :"+save.getCardNo();
	}

}
