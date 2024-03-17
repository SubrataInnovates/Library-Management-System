package com.library.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import com.library.enums.TransactionStatus;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String transactionId;

    @NotNull(message = "Transaction status is required")
    @Enumerated(value=EnumType.STRING)
    private TransactionStatus transactionStatus;

    @NotNull(message = "Issue date is required")
    @PastOrPresent(message = "Issue date must be in the past or present")
    @CreatedDate
    private Date issueDate;

    private Date returnDate;

    @PositiveOrZero(message = "Fine amount must be positive or zero")
    private Integer fineAmount;

    @NotNull(message = "Library card is required")
    @JoinColumn
    @ManyToOne
    private LibraryCard card;

    @NotNull(message = "Book is required")
    @JoinColumn
    @ManyToOne
    private Book book;
}
