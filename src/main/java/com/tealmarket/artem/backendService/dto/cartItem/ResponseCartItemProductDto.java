package com.tealmarket.artem.backendService.dto.cartItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCartItemProductDto {

    private String name;

    private Double price;
}
