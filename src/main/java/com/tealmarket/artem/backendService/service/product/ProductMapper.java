package com.tealmarket.artem.backendService.service.product;

import com.tealmarket.artem.backendService.dto.product.ResponseProductDto;
import com.tealmarket.artem.backendService.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ResponseProductDto productToResponseProductDto(Product product);
}
