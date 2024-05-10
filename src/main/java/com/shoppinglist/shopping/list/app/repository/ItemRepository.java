package com.shoppinglist.shopping.list.app.repository;


import com.shoppinglist.shopping.list.app.entity.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ShoppingItem, Long> {

    @Modifying
    @Query(value = "update ShoppingItem item set item.name= ?1, item.quantity= ?2, item.price= ?3 where item.id= ?4")
    void update(String name, int quantity, double price, Long id);
}