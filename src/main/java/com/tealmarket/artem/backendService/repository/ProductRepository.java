package com.tealmarket.artem.backendService.repository;

import com.tealmarket.artem.backendService.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
