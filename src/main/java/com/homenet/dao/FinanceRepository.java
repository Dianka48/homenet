package com.homenet.dao;

import com.homenet.model.Finance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FinanceRepository extends CrudRepository<Finance, Integer> {
    @Query("from Finance where year(date) = :year")
    Iterable<Finance> findByYear(int year);
}
