package com.backend.backend.controller;


import com.backend.backend.dto.BudgetDTO;
import com.backend.backend.model.Budget;
import com.backend.backend.model.Category;
import com.backend.backend.repository.CategoryRepository;
import com.backend.backend.service.BudgetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public List<Budget> getAllBudgets(){
        return budgetService.getAllBudgets();
    }
    @GetMapping("/{id}")
    public Optional<Budget> getBudgetByid(@PathVariable Long id){
        return budgetService.getBudgetById(id);
    }
    @PostMapping
    public ResponseEntity<Budget> addBudget(@RequestBody BudgetDTO budgetDTO) {
        Budget createdBudget = budgetService.createBudget(budgetDTO);
        return new ResponseEntity<>(createdBudget, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public void deleteBudget(@PathVariable Long id){
        budgetService.deleteBudget(id);
    }
    @PutMapping
    public Budget updateBudget(@RequestBody Budget budget){
        return budgetService.updateBudget(budget);
    }
}
