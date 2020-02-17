package com.homenet.service;

import com.homenet.dao.FinanceRepository;
import com.homenet.model.Finance;
import com.homenet.model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class FinanceService {

    @Autowired
    FinanceRepository repository;

    public Iterable<Finance> findAll() {
        return repository.findAll();
    }

    public void save(Finance finance) {
        repository.save(finance);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Finance findById(int id) {
        Optional<Finance> finance = repository.findById(id);
        return finance.orElse(null);
    }

    public Iterable<Finance> findByYear(int year) {
        return repository.findByYear(year);
    }

    public Iterable<Finance> findByYearAndMonth(int year, int month) {
        return repository.findByYearAndMonth(year, month);
    }

    public Iterable<Finance> findByMonth(int month) {
        return repository.findByMonth(month);
    }
}
