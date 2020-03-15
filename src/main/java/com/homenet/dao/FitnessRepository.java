package com.homenet.dao;

import com.homenet.model.Fitness;
import com.homenet.model.Recipe;
import net.bytebuddy.utility.privilege.SetAccessibleAction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface FitnessRepository extends CrudRepository<Fitness, Integer> {

    Iterable<Fitness> findByName(String name);

    @Query("FROM Fitness ORDER BY name, date")
    Iterable<Fitness> findAllByOrderByNameAndDate();

    @Query("from Fitness where year(date) = :year")
    Iterable<Fitness> findByYear(int year);

    @Query("SELECT name FROM Fitness")
    Set<String> findNames();

    @Query("from Fitness where year(date) = :year and name = :name")
    Iterable<Fitness> findByNameAndYear(int year, String name);

    @Query("from Fitness where year(date) = :year and month(date) = :month")
    Iterable<Fitness> findByYearAndMonth(int year, int month);

    @Query("from Fitness where year(date) = :year and month(date) = :month and name = :name")
    Iterable<Fitness> findByNameAndYearAndMonth(int year, int month, String name);
}
