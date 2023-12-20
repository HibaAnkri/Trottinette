package org.example.Service;

import org.example.Entity.Category;
import org.example.Entity.Trottinette;
import org.example.Repository.CategoryRepository;
import org.example.Repository.TrottinetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}

