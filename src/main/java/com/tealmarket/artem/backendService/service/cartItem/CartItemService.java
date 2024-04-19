package com.tealmarket.artem.backendService.service.cartItem;

import com.tealmarket.artem.backendService.dto.cartItem.ResponseCartItemDto;

import java.util.List;
import java.util.Optional;

public interface CartItemService {

    List<ResponseCartItemDto> getAllCartItems();

    Optional<ResponseCartItemDto> getCartItemById(Long id);

    ResponseCartItemDto orderItem(ResponseCartItemDto item);
}
