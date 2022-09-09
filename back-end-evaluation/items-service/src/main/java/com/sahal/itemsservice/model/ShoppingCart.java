package com.sahal.itemsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    private int itemCount;
    private double grandTotal;
    private double totalDiscount;

    @ManyToMany
    @JoinTable(
            name = "items_in_list",
            joinColumns = @JoinColumn(name = "cartId"),
            inverseJoinColumns = @JoinColumn(name = "itemId")
    )
    private List<Item> itemList = new ArrayList<>();

}
