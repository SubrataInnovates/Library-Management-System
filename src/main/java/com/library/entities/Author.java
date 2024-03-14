package com.library.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @NotNull(message = "Name is required")
    private String name;
    
    @Min(value = 0, message = "Age must be a positive number or zero")
    private Integer age;

    @jakarta.validation.constraints.Email(message = "Invalid email format")
    @NotNull(message = "Email is required")
    private String emailId;

    @PositiveOrZero(message = "Rating must be positive or zero")
    private Double rating;

    @PositiveOrZero(message = "Number of books must be positive or zero")
    @NotNull(message = "Number of books is required")
    private int noOfBooks;
}
