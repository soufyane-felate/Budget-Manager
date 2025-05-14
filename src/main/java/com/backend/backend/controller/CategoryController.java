package com.backend.backend.controller;

import com.backend.backend.model.Category;
import com.backend.backend.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*") // utile si tu fais un front en Angular
public class CategoryController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categorieService.createCategorie(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        return categorieService.updateCategorie(id, updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
    }
}
