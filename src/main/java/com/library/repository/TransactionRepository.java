package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,String>
{
	
}
