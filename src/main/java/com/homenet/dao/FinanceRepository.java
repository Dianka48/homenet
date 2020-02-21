package com.homenet.dao;

import com.homenet.model.Finance;
import com.homenet.model.FinanceCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FinanceRepository extends CrudRepository<Finance, Integer> {
    @Query("from Finance where year(date) = :year")
    Iterable<Finance> findByYear(int year);

    @Query("from Finance where year(date) = :year and month(date) = :month")
    Iterable<Finance> findByYearAndMonth(int year, int month);

    @Query("from Finance where month(date) = :month")
    Iterable<Finance> findByMonth(int month);

    @Query("SELECT finance.cost FROM Finance finance WHERE finance.cost > 0 and year(date) = :year and month(date) = :month")
    Iterable<Double> findAllReceiptsByYearAndMonth(int year, int month);

    @Query("SELECT SUM(finance.cost) FROM Finance finance WHERE finance.cost < 0 and year(date) = :year and month(date) = :month")
    Double findSumOfExpendituresByYearAndMonth(int year, int month);

    @Query("SELECT SUM(cost) FROM Finance WHERE cost < 0 and year(date) = :year")
    Double findSumOfExpendituresByYear(int year);

    @Query("SELECT SUM(cost) FROM Finance WHERE cost > 0 and year(date) = :year")
    Double findSumOfReceiptsByYear(int year);

    @Query("SELECT SUM(cost) FROM Finance WHERE category = :category AND year(date) = :year AND month(date) = :month")
    Double findSumOfCostsByCategoryForYearAndMonth(FinanceCategory category, int year, int month);

    @Query("SELECT SUM(cost) FROM Finance WHERE category = :category AND year(date) = :year")
    Double findSumOfCostsByCategoryForYear(FinanceCategory category, int year);
}
