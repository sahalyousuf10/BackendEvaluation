package com.sahal.itemsservice.repository;

import com.sahal.itemsservice.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, Long> {
}
