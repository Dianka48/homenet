package com.homenet.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class StatisticsModel {

    private double receipts;
    private double expenditures;
    private double total;
    private LocalDate date;
    private String dateString;

    public StatisticsModel(double receipts, double expenditures, int year, int month, int day) {
        this.receipts = receipts;
        this.expenditures = expenditures;
        this.total = receipts + expenditures;
        this.date = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        this.dateString = date.format(formatter);
    }

    public StatisticsModel(double receipts, double expenditures, int year, int month) {
        this(receipts, expenditures, year, month, 1);
    }

    public StatisticsModel(double receipts, double expenditures, int year) {
        this(receipts, expenditures, year, 1, 1);
    }

    public double getReceipts() {
        return receipts;
    }

    public void setReceipts(double receipts) {
        this.receipts = receipts;
    }

    public double getExpenditures() {
        return expenditures;
    }

    public void setExpenditures(double expenditures) {
        this.expenditures = expenditures;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
