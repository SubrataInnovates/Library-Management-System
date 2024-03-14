package com.library.entities;

import java.util.Date;

import com.library.enums.CardStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @NotNull(message = "Card status is required")
    private CardStatus cardStatus;

    @NotNull(message = "Number of books issued is required")
    @Min(value = 0, message = "Number of books issued must be greater than or equal to 0")
    @Column(nullable = false)
    private int noOfBooksIssued;

    @NotNull(message = "Validity date is required")
    @Column(nullable = false)
    private Date validity;
    
    @JoinColumn
    @OneToOne
    private Student student;
}
