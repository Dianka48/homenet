package com.homenet.service;

import com.homenet.dao.FinanceCategoryRepository;
import com.homenet.dao.FinanceRepository;
import com.homenet.model.Finance;
import com.homenet.model.FinanceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FinanceCategoryService {

    @Autowired
    FinanceCategoryRepository repository;

    public Iterable<FinanceCategory> findAll() {
        return repository.findAll();
    }

    public FinanceCategory findById(int id) {
        Optional<FinanceCategory> financeCategory = repository.findById(id);
        return financeCategory.orElse(null);
    }
}
