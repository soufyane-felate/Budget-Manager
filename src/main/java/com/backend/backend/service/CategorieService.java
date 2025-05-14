package com.backend.backend.service;

import com.backend.backend.model.Category;
import com.backend.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategorieService {

    @Autowired
    private CategoryRepository categorieRepository;


    public List<Category> getAllCategories() {
        return categorieRepository.findAll();
    }


    public Optional<Category> getCategorieById(Long id) {
        return categorieRepository.findById(id);
    }


    public Category createCategorie(Category categorie) {
        return categorieRepository.save(categorie);
    }


    public Category updateCategorie(Long id, Category updatedCategorie) {
        return categorieRepository.findById(id)
                .map(categorie -> {
                    categorie.setNom(updatedCategorie.getNom());
                    categorie.setType(updatedCategorie.getType());
                    categorie.setDescription(updatedCategorie.getDescription());
                    return categorieRepository.save(categorie);
                })
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec l'id: " + id));
    }


    public void deleteCategorie(Long id) {
        if (!categorieRepository.existsById(id)) {
            throw new RuntimeException("Catégorie non trouvée avec l'id: " + id);
        }
        categorieRepository.deleteById(id);
    }
}
