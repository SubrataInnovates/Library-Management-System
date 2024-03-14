package com.library.entities;

import com.library.enums.Genre;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @NotBlank(message = "Title is required")
    private String title;

    @PositiveOrZero(message = "Number of pages must be positive or zero")
    @NotNull(message = "Number of pages is required")
    private Integer noOfPages;
    
    @PositiveOrZero(message = "Price must be positive or zero")
    @NotNull(message = "Price is required")
    private Integer price;

    @NotNull(message = "Genre is required")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @JoinColumn
    @ManyToOne
    private Author author;
}
