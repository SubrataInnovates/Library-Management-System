package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entities.LibraryCard;

public interface CardRepository extends JpaRepository<LibraryCard,Integer>
{

}
