package com.tealmarket.artem.backendService.service.product;

import com.tealmarket.artem.backendService.dto.product.ResponseProductDto;
import com.tealmarket.artem.backendService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private static final ProductMapper PRODUCT_MAPPER = ProductMapper.INSTANCE;

    private final ProductRepository productRepository;

    @Override
    public List<ResponseProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(PRODUCT_MAPPER::productToResponseProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResponseProductDto> getProductById(Long id) {
        return productRepository.findById(id)
                .map(PRODUCT_MAPPER::productToResponseProductDto);
    }
}
