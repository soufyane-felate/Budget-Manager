package com.backend.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    private Long id;

    private double amount;


    private LocalDate date;

    private String description;

    @ManyToOne
    private Category category;
}
