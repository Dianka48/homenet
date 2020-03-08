package com.homenet.dao;

import com.homenet.model.Recipe;
import com.homenet.model.RecipeCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Iterable<Recipe> findAllByOrderByName();

    Recipe findByName(String name);

    @Query("FROM Recipe ORDER BY category, name")
    Iterable<Recipe> findAllByOrderByCategoryAndName();

    @Query("FROM Recipe WHERE category = :category ORDER BY name")
    Iterable<Recipe> findByCategoryOrderByName(RecipeCategory category);

}
