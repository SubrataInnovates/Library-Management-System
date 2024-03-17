package com.library.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.Book;
import com.library.entities.LibraryCard;
import com.library.entities.Transaction;
import com.library.enums.TransactionStatus;
import com.library.repository.BookRepository;
import com.library.repository.CardRepository;
import com.library.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService
{
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public static Integer max_no_of_issued_books=3;

	@Override
	public String issueBook(Integer bookId, Integer cardId) throws Exception
	{
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		
		if(bookOptional.isEmpty())
		{
			throw new Exception("Invalid Book id !! try another one !!");
		}
		Book book = bookOptional.get();
		
		Optional<LibraryCard> cardOpional = cardRepository.findById(cardId);
		if(cardOpional.isEmpty())
		{
			throw new Exception("Invalid Card id !! try another one !!");
		}
		LibraryCard card = cardOpional.get();
		
		Transaction transaction=new Transaction();
		transaction.setBook(book);
		transaction.setCard(card);
		transaction.setTransactionStatus(TransactionStatus.PENDING);
		
		if(book.getIsIssued())
		{
			transaction.setTransactionStatus(TransactionStatus.FAILURE);
			transactionRepository.save(transaction);
			return " Book is already issued to card  !!"+card.getCardNo();
		}
		if(card.getNoOfBooksIssued()>max_no_of_issued_books)
		{
			transaction.setTransactionStatus(TransactionStatus.FAILURE);
			transactionRepository.save(transaction);
			return " Max no of issued books is exceed !!";
		}
		LocalDate currentDate=LocalDate.now();
		if(currentDate.isAfter(card.getValidity()))
		{
			transaction.setTransactionStatus(TransactionStatus.FAILURE);
			transactionRepository.save(transaction);
			return " Your card has been expired !!";
		}
		
		transaction.setTransactionStatus(TransactionStatus.SCUCCESS);
		
		book.setIsIssued(true);
		card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);
		
		cardRepository.save(card);
		bookRepository.save(book);
		
		Transaction save = transactionRepository.save(transaction);
		
		
		return "Transaction has been completed"+save.getTransactionId();
	}

}
