package com.tealmarket.artem.backendService.service.cartItem;

import com.tealmarket.artem.backendService.dto.cartItem.ResponseCartItemDto;
import com.tealmarket.artem.backendService.model.cart.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartItemMapper {

    CartItemMapper INSTANCE = Mappers.getMapper(CartItemMapper.class);

    ResponseCartItemDto cartItemToCartItemDto(CartItem cartItem);

    CartItem cartItemDtoToCartItem(ResponseCartItemDto cartItemDto);
}
