package com.homenet.controller;

import com.homenet.model.Recipe;
import com.homenet.model.RecipeCategory;
import com.homenet.service.RecipeCategoryService;
import com.homenet.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Map;


@Controller
public class RecipeController {

    @Autowired
    RecipeService service;
    @Autowired
    RecipeCategoryService categoryService;

    @GetMapping("/recipes")
    public String recipes(Model model, HttpServletRequest request) {
        addDataToModel(model, request);
        return "recipes";
    }

    private void addDataToModel(Model model, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            if (inputFlashMap.containsKey("category")) {
                String category = (String) inputFlashMap.get("category");
                model.addAttribute("recipes", service.findByCategoryOrderByName(category));
            }
        }
        else {
            model.addAttribute("recipes", service.findAllOrderByCategoryAndName());
        }
    }

    @PostMapping("/recipes")
    public String findByCategory(RedirectAttributes redirectAttributes, String category) {
        if (category != null) {
            redirectAttributes.addFlashAttribute("category", category);
        }
        return "redirect:/recipes";
    }

    @GetMapping("/addrecipe")
    public String addRecipe(Model model) {
        Iterable<RecipeCategory> categories = categoryService.findAllByOrderById();
        model.addAttribute("categories", categories);
        return "addrecipe";
    }


    @GetMapping("/recipe/{name}")
    public String recipe(Model model, @PathVariable String name) {
        Recipe recipe = service.findByName(name);
        model.addAttribute("recipe", recipe);
        if (recipe.getPhoto() != null && recipe.getPhoto().length > 0) {
            model.addAttribute("image", Base64.getEncoder().encodeToString(recipe.getPhoto()));
        }
        return "recipe";
    }
//
//    @GetMapping("/editfinance/{id}")
//    public String editFinance(Model model, @PathVariable int id) {
//        Iterable<FinanceCategory> categories = categoryService.findAll();
//        model.addAttribute("categories", categories);
//        Finance finance = service.findById(id);
//        model.addAttribute("finance", finance);
//        return "editfinance";
//    }
//
//    @PostMapping("/editfinance")
//    public String editFinancePost(Finance finance) {
//        service.save(finance);
//        return "redirect:/finances";
//    }
//
    @PostMapping("/addrecipe")
    public String addRecipe(Recipe recipe, @RequestParam("image") MultipartFile image) {
        service.addImage(recipe, image);
        service.save(recipe);
        return "redirect:/recipes";
    }


    @DeleteMapping("/deleterecipe/{id}")
    @ResponseBody
    public String deleteFinance(@PathVariable int id) {
        service.deleteById(id);
        return "";
    }

//    @GetMapping("/statistics")
//    public String statistics(Model model, HttpServletRequest request) {
//        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
//        if (inputFlashMap != null) {
//            if (inputFlashMap.containsKey("year") && inputFlashMap.containsKey("month")) {
//                int year = (Integer) inputFlashMap.get("year");
//                int month = (Integer) inputFlashMap.get("month");
//                StatisticsModel statisticsModel = service.addStatisticsByYearAndMonth(year, month);
//                model.addAttribute("statisticsModel", statisticsModel);
//                Map sumOfCostsForAllCategoriesByYearAndMonth = service.findSumOfCostsForAllCategoriesByYearAndMonth(year, month);
//                model.addAttribute("categoryMap", sumOfCostsForAllCategoriesByYearAndMonth);
//            } else if (inputFlashMap.containsKey("year")) {
//                int year = (Integer) inputFlashMap.get("year");
//                StatisticsModel statisticsModel = service.addStatisticsByYear(year);
//                model.addAttribute("statisticsModel", statisticsModel);
//                Map sumOfCostsForAllCategoriesByYear = service.findSumOfCostsForAllCategoriesByYear(year);
//                model.addAttribute("categoryMap", sumOfCostsForAllCategoriesByYear);
//            }
//        }
//        return "statistics";
//    }
//
//    @PostMapping("/statistics")
//        public String statisticsPost(RedirectAttributes redirectAttributes, Integer year, Integer month) {
//            if(year != null) {
//                redirectAttributes.addFlashAttribute("year", year);
//            }
//            if(month != null) {
//                redirectAttributes.addFlashAttribute("month", month);
//            }
//            return "redirect:statistics";
//        }

}
