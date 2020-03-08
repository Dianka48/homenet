package com.homenet.service;

import com.homenet.dao.ShoppingItemRepository;
import com.homenet.model.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingItemRepository repository;

    public Iterable<ShoppingItem> findAll() {
        return repository.findAll();
    }

    public void save(ShoppingItem item) {
        repository.save(item);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public ShoppingItem findById(int id) {
        Optional<ShoppingItem> shoppingItem = repository.findById(id);
        return shoppingItem.orElse(null);
    }
}
