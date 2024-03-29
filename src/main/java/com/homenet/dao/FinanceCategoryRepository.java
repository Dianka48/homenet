package com.homenet.dao;

import com.homenet.model.FinanceCategory;
import org.springframework.data.repository.CrudRepository;

public interface FinanceCategoryRepository extends CrudRepository<FinanceCategory, Integer> {

    Iterable<FinanceCategory> findAllByOrderById();
}
