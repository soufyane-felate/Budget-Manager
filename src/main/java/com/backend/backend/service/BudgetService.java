package com.backend.backend.service;


import com.backend.backend.model.Budget;
import com.backend.backend.model.Category;
import com.backend.backend.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.backend.dto.BudgetDTO;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {
    private CategorieService categorieService;
    private BudgetRepository budgetRepository;
    private BudgetDTO budgetDTO;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }
    public List<Budget> getAllBudgets(){
        return budgetRepository.findAll();
    }

    public Budget createBudget(BudgetDTO budgetDTO) {
        Category category = categorieService.getCategorieById(budgetDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Budget budget = new Budget();
        budget.setBudgetLimit(budgetDTO.getBudgetLimit());
        budget.setCategory(budgetDTO.getCategoryId());
        return budgetRepository.save(budget);
    }

    public Optional<Budget> getBudgetById(Long id){
        return budgetRepository.findById(id);
    }

    public Budget updateBudget (Budget budget){
        return budgetRepository.save(budget);
    }

    public void deleteBudget(Long id){
         budgetRepository.deleteById(id);
    }
}
