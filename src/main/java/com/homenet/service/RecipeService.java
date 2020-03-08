package com.homenet.service;


import com.homenet.dao.RecipeRepository;
import com.homenet.model.Recipe;
import com.homenet.model.RecipeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository repository;
    @Autowired
    RecipeCategoryService categoryService;

    public Iterable<Recipe> findAllOrderByName() {
        return repository.findAllByOrderByName();
    }

    public Recipe findByName(String name) {
        return repository.findByName(name);
    }

    public Iterable<Recipe> findAllOrderByCategoryAndName() {
        return repository.findAllByOrderByCategoryAndName();
    }

    public void save(Recipe item) {
        repository.save(item);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Iterable<Recipe> findByCategoryOrderByName(String category) {
        RecipeCategory recipeCategory = categoryService.findByLabel(category);
        return repository.findByCategoryOrderByName(recipeCategory);
    }

    public void addImage(Recipe recipe, MultipartFile image) {
        if (image != null) {
            try {
                recipe.setPhoto(image.getBytes());
            } catch (IOException e) {
                System.err.println(e);
            }
        }

    }

}
