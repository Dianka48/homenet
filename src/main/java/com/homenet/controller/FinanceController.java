package com.homenet.controller;

import com.homenet.model.Finance;
import com.homenet.model.FinanceCategory;
import com.homenet.model.ShoppingItem;
import com.homenet.service.FinanceCategoryService;
import com.homenet.service.FinanceService;
import com.homenet.service.ShoppingListService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;


@Controller
public class FinanceController {

    @Autowired
    FinanceService service;
    @Autowired
    FinanceCategoryService categoryService;

    @GetMapping("/finances")
    public String finances(Model model, HttpServletRequest request) {
        addDataToModel(model, request);
        return "finances";
    }

    private void addDataToModel(Model model, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if(inputFlashMap != null) {
            if(inputFlashMap.containsKey("year") && inputFlashMap.containsKey("month")) {
                int year = (Integer) inputFlashMap.get("year");
                int month = (Integer) inputFlashMap.get("month");
                model.addAttribute("finances", service.findByYearAndMonth(year, month));
            } else if(inputFlashMap.containsKey("year")) {
                int year = (Integer) inputFlashMap.get("year");
                model.addAttribute("finances", service.findByYear(year));
            } else if(inputFlashMap.containsKey("month")) {
                int month = (Integer) inputFlashMap.get("month");
                model.addAttribute("finances", service.findByMonth(month));
            }
        } else {
            model.addAttribute("finances", service.findAll());
        }
    }

    @PostMapping("/finances")
    public String findByYearAndMonth(RedirectAttributes redirectAttributes, Integer year, Integer month) {
        if(year != null) {
            redirectAttributes.addFlashAttribute("year", year);
        }
        if(month != null) {
            redirectAttributes.addFlashAttribute("month", month);
        }
        return "redirect:/finances";
    }

    @GetMapping("/addfinance")
    public String addFinance(Model model) {
        Iterable<FinanceCategory> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "addfinance";
    }

    @GetMapping("/editfinance/{id}")
    public String editFinance(Model model, @PathVariable int id) {
        Iterable<FinanceCategory> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        Finance finance = service.findById(id);
        model.addAttribute("finance", finance);
        return "editfinance";
    }

    @PostMapping("/editfinance")
    public String editFinancePost(Finance finance) {
        service.save(finance);
        return "redirect:/finances";
    }

    @PostMapping("/addfinance")
    public String addFinancePost(Finance finance) {
        service.save(finance);
        return "redirect:/finances";
    }

    @DeleteMapping("/deletefinance/{id}")
    @ResponseBody
    public String deleteFinance(@PathVariable int id) {
        service.deleteById(id);
        return "";
    }

    @GetMapping("/statistics")
    public String statistics(Model model, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if(inputFlashMap != null) {
            if(inputFlashMap.containsKey("year") && inputFlashMap.containsKey("month")) {
                int year = (Integer) inputFlashMap.get("year");
                int month = (Integer) inputFlashMap.get("month");
                int day = 1;
                LocalDate date = LocalDate.of(year, month, day);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
                String dateString = date.format(formatter);
                model.addAttribute("date", dateString);
                double allReceiptsByYearAndMonth = service.findAllReceiptsByYearAndMonth(year, month);
                double sumOfExpendituresByYearAndMonth = service.findSumOfExpendituresByYearAndMonth(year, month);
                double total = allReceiptsByYearAndMonth + sumOfExpendituresByYearAndMonth;
                model.addAttribute("receipts", allReceiptsByYearAndMonth);
                model.addAttribute("totalReceipts", "Total Receipts:");
                model.addAttribute("expenditures", sumOfExpendituresByYearAndMonth);
                model.addAttribute("totalExpenditures", "Total Expenditures:");
                model.addAttribute("totalText", "Total");
                model.addAttribute("totalValue", total);
            } else if(inputFlashMap.containsKey("year")) {
                int year = (Integer) inputFlashMap.get("year");
                int month = 1;
                int day = 1;
                LocalDate date = LocalDate.of(year, month, day);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
                String dateString = date.format(formatter);
                model.addAttribute("date", dateString);
                double sumOfExpendituresByYear = service.findSumOfExpendituresByYear(year);
                double sumOfReceiptsByYear = service.findSumOfReceiptsByYear(year);
                double total = sumOfReceiptsByYear + sumOfExpendituresByYear;
                model.addAttribute("expenditures", sumOfExpendituresByYear);
                model.addAttribute("totalExpenditures", "Total Expenditures:");
                model.addAttribute("receipts", sumOfReceiptsByYear);
                model.addAttribute("totalReceipts", "Total Receipts:");
                model.addAttribute("totalText", "Total");
                model.addAttribute("totalValue", total);
            }
        } else {
            model.addAttribute("select", "Select Year and Month");
        }
        return "statistics";
    }

    @PostMapping("/statistics")
        public String statisticsPost(RedirectAttributes redirectAttributes, Integer year, Integer month) {
            if(year != null) {
                redirectAttributes.addFlashAttribute("year", year);
            }
            if(month != null) {
                redirectAttributes.addFlashAttribute("month", month);
            }
            return "redirect:statistics";
        }

}
