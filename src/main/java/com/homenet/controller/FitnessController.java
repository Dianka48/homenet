package com.homenet.controller;

import com.homenet.model.Fitness;
import com.homenet.service.FitnessService;
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
import java.util.Set;


@Controller
public class FitnessController {

    @Autowired
    FitnessService service;

    @GetMapping("/fitness")
    public String fitness(Model model, HttpServletRequest request) {
        Set<String> names = service.findNames();
        model.addAttribute("names", names);
        addDataToModel(model, request);
        return "fitness";
    }

    private void addDataToModel(Model model, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            if (inputFlashMap.containsKey("year") && inputFlashMap.containsKey("month")) {
                int year = (Integer) inputFlashMap.get("year");
                int month = (Integer) inputFlashMap.get("month");
                model.addAttribute("fitness", service.findByYearAndMonth(year, month));
            } else if (inputFlashMap.containsKey("failedMessage")) {
                String failedMessage = (String) inputFlashMap.get("failedMessage");
                model.addAttribute("failedMessage", failedMessage);
            } else if (inputFlashMap.containsKey("year")) {
                int year = (Integer) inputFlashMap.get("year");
                model.addAttribute("fitness", service.findByYear(year));
            } else if (inputFlashMap.containsKey("name") && inputFlashMap.containsKey("year") && inputFlashMap.containsKey("month")) {
                int year = (Integer) inputFlashMap.get("year");
                int month = (Integer) inputFlashMap.get("month");
                String name = (String) inputFlashMap.get("name");
                model.addAttribute("fitness", service.findByNameAndYearAndMonth(year, month, name));
            } else if (inputFlashMap.containsKey("year") && inputFlashMap.containsKey("name")) {
                int year = (Integer) inputFlashMap.get("year");
                String name = (String) inputFlashMap.get("name");
                model.addAttribute("fitness", service.findByNameAndYear(year, name));
            } else if (inputFlashMap.containsKey("name")) {
                String name = (String) inputFlashMap.get("name");
                model.addAttribute("fitness", service.findByName(name));
            }
        }
        else {
            model.addAttribute("fitness", service.findAllByOrderByNameAndDate());
        }
    }

    @PostMapping("/fitness")
    public String findByNameAndYearAndMonth(RedirectAttributes redirectAttributes, Integer year, Integer month, String name) {
        if (month != null && year == null) {
            redirectAttributes.addFlashAttribute("failedMessage", "Please select year when you are selecting month.");
            return "redirect:/fitness/";
        }
        if(year != null) {
            redirectAttributes.addFlashAttribute("year", year);
        }
        if(month != null) {
            redirectAttributes.addFlashAttribute("month", month);
        }
        if(name != null) {
            if (!"All".equals(name)) {
                redirectAttributes.addFlashAttribute("name", name);
            }
        }
        return "redirect:/fitness";
    }

    @GetMapping("/addfitness")
    public String addFitness(Model model) {
        return "addfitness";
    }

    @GetMapping("/editfitness/{id}")
    public String editFitness(Model model, @PathVariable int id) {
        Fitness fitness = service.findById(id);
        model.addAttribute("fitness", fitness);
        return "editfitness";
    }

    @PostMapping("/editfitness")
    public String editFitnessPost(Fitness fitness) {
        service.save(fitness);
        return "redirect:/fitness";
    }

    @PostMapping("/addfitness")
    public String addFitnessPost(Fitness fitness) {
        service.save(fitness);
        return "redirect:/fitness";
    }

    @DeleteMapping("/deletefitness/{id}")
    @ResponseBody
    public String deleteFitness(@PathVariable int id) {
        service.deleteById(id);
        return "";
    }
}
