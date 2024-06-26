package com.tealmarket.artem.backendService.service.product;

import com.tealmarket.artem.backendService.dto.product.ResponseProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ResponseProductDto> getAllProducts();

    List<ResponseProductDto> getAllProductsByCompanyName(String brandName);

    Optional<ResponseProductDto> getProductById(Long id, String brandName);
}
