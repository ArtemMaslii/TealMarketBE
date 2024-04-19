package com.tealmarket.artem.backendService.dto.cartItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tealmarket.artem.backendService.dto.product.details.ResponseColorDto;
import com.tealmarket.artem.backendService.dto.product.details.ResponseStorageSpaceDto;
import com.tealmarket.artem.backendService.model.product.Product;
import com.tealmarket.artem.backendService.model.product.details.Color;
import com.tealmarket.artem.backendService.model.product.details.StorageSpace;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCartItemDto {

    @JsonIgnore
    private Long id;

    private ResponseCartDto cart;

    private ResponseCartItemProductDto product;

    private ResponseColorDto color;

    private ResponseStorageSpaceDto storageSpace;
}
