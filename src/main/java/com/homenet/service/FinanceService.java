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

    public double findAllReceiptsByYearAndMonth(int year, int month) {
        Iterable<Double> allReceiptsByYearAndMonth = repository.findAllReceiptsByYearAndMonth(year, month);
        if(allReceiptsByYearAndMonth != null) {
            double total = 0;
            for(double receipt : allReceiptsByYearAndMonth) {
                total += receipt;
            }
            return total;
        } else {
            return 0.0;
        }

    }

    public double findSumOfExpendituresByYearAndMonth (int year, int month) {
        if(repository.findSumOfExpendituresByYearAndMonth(year, month) != null) {
            return repository.findSumOfExpendituresByYearAndMonth(year, month);
        } else {
            return 0.0;
        }

    }

    public double findSumOfExpendituresByYear(int year) {
        if(repository.findSumOfExpendituresByYear(year) != null) {
            return repository.findSumOfExpendituresByYear(year);
        } else {
            return 0.0;
        }
    }

    public double findSumOfReceiptsByYear(int year) {
        if(repository.findSumOfReceiptsByYear(year) != null) {
            return repository.findSumOfReceiptsByYear(year);
        } else {
            return 0.0;
        }

    }
}
