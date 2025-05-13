package com.backend.backend.controller;



import com.backend.backend.dto.TransactionDTO;
import com.backend.backend.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionDTO> getAll() {
        return transactionService.getAll();
    }

    @PostMapping
    public TransactionDTO create(@RequestBody TransactionDTO dto) {
        return transactionService.add(dto);
    }

    @PutMapping("/{id}")
    public TransactionDTO update(@PathVariable Long id, @RequestBody TransactionDTO dto) {
        return transactionService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transactionService.delete(id);
    }
}
