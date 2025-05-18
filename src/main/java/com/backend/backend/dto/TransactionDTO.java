package com.backend.backend.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDTO {
    private Long id;
    private Double amount;
    private String description;
    private LocalDate date;
    private Long categoryId;
}


