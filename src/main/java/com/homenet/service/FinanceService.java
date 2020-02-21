package com.homenet.service;

import com.homenet.dao.FinanceCategoryRepository;
import com.homenet.dao.FinanceRepository;
import com.homenet.model.Finance;
import com.homenet.model.FinanceCategory;
import com.homenet.model.ShoppingItem;
import com.homenet.model.StatisticsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class FinanceService {

    @Autowired
    FinanceRepository repository;
    @Autowired
    FinanceCategoryRepository categoryRepository;

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

    public double findSumOfExpendituresByYearAndMonth(int year, int month) {
        if (repository.findSumOfExpendituresByYearAndMonth(year, month) != null) {
            return repository.findSumOfExpendituresByYearAndMonth(year, month);
        } else {
            return 0.0;
        }

    }

    public double findSumOfExpendituresByYear(int year) {
        if (repository.findSumOfExpendituresByYear(year) != null) {
            return repository.findSumOfExpendituresByYear(year);
        } else {
            return 0.0;
        }
    }

    public double findSumOfReceiptsByYear(int year) {
        if (repository.findSumOfReceiptsByYear(year) != null) {
            return repository.findSumOfReceiptsByYear(year);
        } else {
            return 0.0;
        }
    }

    public StatisticsModel addStatisticsByYearAndMonth(int year, int month) {
        double receipts = findAllReceiptsByYearAndMonth(year, month);
        double expenditures = findSumOfExpendituresByYearAndMonth(year, month);
        return new StatisticsModel(receipts, expenditures, year, month);
    }

    public StatisticsModel addStatisticsByYear(int year) {
        double receipts = findSumOfReceiptsByYear(year);
        double expenditures = findSumOfExpendituresByYear(year);
        return new StatisticsModel(receipts, expenditures, year);
    }

    public Map findSumOfCostsForAllCategoriesByYearAndMonth(int year, int month) {
        Iterable<FinanceCategory> categories = categoryRepository.findAllByOrderById();
        Map<FinanceCategory, Double> categoryCostMap = new LinkedHashMap<>();
        for (FinanceCategory category : categories) {
            if (repository.findSumOfCostsByCategoryForYearAndMonth(category, year, month) != null) {
                categoryCostMap.put(category, repository.findSumOfCostsByCategoryForYearAndMonth(category, year, month));
            } else {
                categoryCostMap.put(category, 0.0);
            }
        }
        return categoryCostMap;
    }

    public Map findSumOfCostsForAllCategoriesByYear(int year) {
        Iterable<FinanceCategory> categories = categoryRepository.findAllByOrderById();
        Map<FinanceCategory, Double> categoryCostMap = new LinkedHashMap<>();
        for (FinanceCategory category : categories) {
            if (repository.findSumOfCostsByCategoryForYear(category, year) != null) {
                categoryCostMap.put(category, repository.findSumOfCostsByCategoryForYear(category, year));
            } else {
                categoryCostMap.put(category, 0.0);
            }
        }
        return categoryCostMap;
    }
}
