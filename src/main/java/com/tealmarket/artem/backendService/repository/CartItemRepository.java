package com.tealmarket.artem.backendService.repository;

import com.tealmarket.artem.backendService.model.cart.Cart;
import com.tealmarket.artem.backendService.model.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findAllByCart(Cart cart);
}
