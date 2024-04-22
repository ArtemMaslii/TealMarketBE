package com.tealmarket.artem.backendService.controller;

import com.tealmarket.artem.backendService.dto.product.ResponseProductDto;
import com.tealmarket.artem.backendService.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ResponseProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{brandName}")
    public List<ResponseProductDto> getAllProductsByCompanyName(@PathVariable String brandName) {
        return productService.getAllProductsByCompanyName(brandName);
    }

    @GetMapping("/{brandName}/{id}")
    public ResponseEntity<ResponseProductDto> getProductById(@PathVariable String brandName, @PathVariable Long id) {
        Optional<ResponseProductDto> product = productService.getProductById(id, brandName);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
