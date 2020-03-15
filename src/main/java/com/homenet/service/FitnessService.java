package com.homenet.service;


import com.homenet.dao.FitnessRepository;
import com.homenet.model.Fitness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

@Service
public class FitnessService {

    @Autowired
    FitnessRepository repository;

    public Iterable<Fitness> findAll() {
        return repository.findAll();
    }

    public Iterable<Fitness> findAllByOrderByNameAndDate() {
        return repository.findAllByOrderByNameAndDate();
    }

    public Set<String> findNames() {
        return repository.findNames();
    }

    public void save(Fitness fitness) {
        repository.save(fitness);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Fitness findById(int id) {
        Optional<Fitness> fitness = repository.findById(id);
        return fitness.orElse(null);
    }

    public Iterable<Fitness> findByYear(int year) {
        return repository.findByYear(year);
    }

    public Iterable<Fitness> findByName(String name) {
        return repository.findByName(name);
    }

    public Iterable<Fitness> findByNameAndYear(int year, String name) {
        return repository.findByNameAndYear(year, name);
    }

    public Iterable<Fitness> findByYearAndMonth(int year, int month) {
        return repository.findByYearAndMonth(year, month);
    }

    public Iterable<Fitness> findByNameAndYearAndMonth(int year, int month, String name) {
        return repository.findByNameAndYearAndMonth(year, month, name);
    }

}
