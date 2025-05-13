package com.backend.backend.service;

import com.backend.backend.model.Category;
import com.backend.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategoryRepository categorieRepository;

    // Get all categories
    public List<Category> getAllCategories() {
        return categorieRepository.findAll();
    }

    // Get one category by ID
    public Optional<Category> getCategorieById(Long id) {
        return categorieRepository.findById(Math.toIntExact(id));
    }

    // Create a new category
    public Category createCategorie(Category categorie) {
        return categorieRepository.save(categorie);
    }

    // Update a category by ID
    public Category updateCategorie(Long id, Category updatedCategorie) {
        return categorieRepository.findById(Math.toIntExact(id))
                .map(categorie -> {
                    categorie.setNom(updatedCategorie.getNom());
                    categorie.setType(updatedCategorie.getType());
                    categorie.setDescription(updatedCategorie.getDescription());
                    return categorieRepository.save(categorie);
                })
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
    }

    // Delete a category by ID
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(Math.toIntExact(id));
    }
}
