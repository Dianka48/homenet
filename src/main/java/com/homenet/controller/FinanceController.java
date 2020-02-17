package com.homenet.controller;

import com.homenet.model.Finance;
import com.homenet.model.FinanceCategory;
import com.homenet.model.ShoppingItem;
import com.homenet.service.FinanceCategoryService;
import com.homenet.service.FinanceService;
import com.homenet.service.ShoppingListService;
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

}
