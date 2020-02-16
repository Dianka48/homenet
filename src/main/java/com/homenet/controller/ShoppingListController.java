package com.homenet.controller;

import com.homenet.model.ShoppingItem;
import com.homenet.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ShoppingListController {

    @Autowired
    ShoppingListService service;

    @GetMapping("/shoppinglist")
    public String shoppingList(Model model) {
        Iterable<ShoppingItem> items = service.findAll();
        model.addAttribute("items", items);
        return "shoppinglist";
    }

    @GetMapping("/additem")
    public String addShoppingItem() {
        return "additem";
    }

    @GetMapping("/edititem/{id}")
    public String editShoppingItem(Model model, @PathVariable int id) {
        ShoppingItem shoppingItem = service.findById(id);
        model.addAttribute("item", shoppingItem);
        return "edititem";
    }

    @PostMapping("/edititem")
    public String editShoppingItemPost(ShoppingItem item) {
        service.save(item);
        return "redirect:/shoppinglist";
    }

    @PostMapping("/additem")
    public String addShoppingItemPost(ShoppingItem item) {
        service.save(item);
        return "redirect:/shoppinglist";
    }

    @DeleteMapping("/deleteitem/{id}")
    @ResponseBody
    public String deleteShoppingItem(@PathVariable int id) {
        service.deleteById(id);
        return "";
    }

}
