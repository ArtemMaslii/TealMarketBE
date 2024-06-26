package com.tealmarket.artem.backendService.repository;

import com.tealmarket.artem.backendService.model.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
