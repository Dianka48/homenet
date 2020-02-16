package com.homenet.dao;

import com.homenet.model.ShoppingItem;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Integer> {

}
