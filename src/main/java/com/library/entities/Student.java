package com.library.entities;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    @Column(nullable = false, length = 20)
    private String name;

    @NotBlank(message = "Branch is required")
    @Column(nullable = false, length = 20)
    private String branch;

    @NotNull(message = "CGPA is required")
    @Column(nullable = false)
    private Double cgpa;

    @NotBlank(message = "Email ID is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true, length = 20)
    private String emailId;
}

