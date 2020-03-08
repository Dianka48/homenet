package com.homenet.dao;

import com.homenet.model.RecipeCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory, Integer> {

    Iterable<RecipeCategory> findAllByOrderById();
    Optional<RecipeCategory> findByLabel(String label);
}
