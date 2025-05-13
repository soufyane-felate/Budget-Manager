package com.backend.backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    private String type;

    private String description;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

