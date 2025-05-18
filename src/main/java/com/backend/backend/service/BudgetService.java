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
    private final CategoryService categoryService;
    private final BudgetRepository budgetRepository;

    @Autowired
    public BudgetService(BudgetRepository budgetRepository, CategoryService categoryService) {
        this.budgetRepository = budgetRepository;
        this.categoryService = categoryService;
    }

    public Budget createBudget(BudgetDTO budgetDTO) {
        Category category = categoryService.getCategoryById(budgetDTO.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category with ID " + budgetDTO.getCategoryId() + " not found"));
        Budget budget = new Budget();
        budget.setBudgetLimit(budgetDTO.getBudgetLimit());
        budget.setCategory(category.getId());
        return budgetRepository.save(budget);
    }

    public Optional<Budget> getBudgetById(Long id) {
        return budgetRepository.findById(id);
    }

    public Budget updateBudget(Budget budget) {
        if (!budgetRepository.existsById(budget.getId())) {
            throw new IllegalArgumentException("Budget with ID " + budget.getId() + " not found");
        }
        return budgetRepository.save(budget);
    }

    public void deleteBudget(Long id) {
        if (!budgetRepository.existsById(id)) {
            throw new IllegalArgumentException("Budget with ID " + id + " not found");
        }
        budgetRepository.deleteById(id);
    }

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }
}