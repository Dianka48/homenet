package com.homenet.service;

import com.homenet.dao.FinanceCategoryRepository;
import com.homenet.dao.RecipeCategoryRepository;
import com.homenet.model.FinanceCategory;
import com.homenet.model.Recipe;
import com.homenet.model.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeCategoryService {

    @Autowired
    RecipeCategoryRepository repository;

    public Iterable<RecipeCategory> findAllByOrderById() {
        return repository.findAllByOrderById();
    }

    public RecipeCategory findByLabel(String category) {
        Optional<RecipeCategory> recipeCategory = repository.findByLabel(category);
        return recipeCategory.orElse(null);
    }
}
