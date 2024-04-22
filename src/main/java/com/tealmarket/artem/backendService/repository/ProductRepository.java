package com.tealmarket.artem.backendService.repository;

import com.tealmarket.artem.backendService.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByNameContainingIgnoreCase(String brandName);

    Optional<Product> findByIdAndNameContainingIgnoreCase(Long id, String brandName);
}
