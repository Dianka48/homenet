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
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null && inputFlashMap.containsKey("year")) {
            int year = (Integer) inputFlashMap.get("year");
            Iterable<Finance> financesByYear = service.findByYear(year);
            model.addAttribute("finances", financesByYear);
        } else {
            Iterable<Finance> finances = service.findAll();
            model.addAttribute("finances", finances);
        }
        return "finances";
    }

    @PostMapping("/finances")
    public String findByYear(RedirectAttributes redirectAttributes, Integer year) {
        if(year != null) {
            redirectAttributes.addFlashAttribute("year", year);
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
