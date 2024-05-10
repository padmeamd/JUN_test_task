package com.shoppinglist.shopping.list.app.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "shopping_items")
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;
    private double price;
}
