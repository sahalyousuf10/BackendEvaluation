package com.sahal.itemsservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.sahal.itemsservice.model.ShoppingCart;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private long itemId;
    private int quantity;
    private long upc;
    private String color;
    private double price;
    private double discount;

    @JsonIgnore
    @ManyToMany(mappedBy = "itemList")
    private List<Item> items = new ArrayList<>();
}
