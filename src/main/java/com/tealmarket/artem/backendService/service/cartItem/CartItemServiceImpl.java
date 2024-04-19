package com.tealmarket.artem.backendService.service.cartItem;

import com.tealmarket.artem.backendService.dto.cartItem.ResponseCartItemDto;
import com.tealmarket.artem.backendService.model.cart.CartItem;
import com.tealmarket.artem.backendService.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartItemServiceImpl implements CartItemService {

    private static final CartItemMapper CART_ITEM_MAPPER = CartItemMapper.INSTANCE;

    private final CartItemRepository cartItemRepository;

    @Override
    public List<ResponseCartItemDto> getAllCartItems() {
        return cartItemRepository.findAll().stream()
                .map(CART_ITEM_MAPPER::cartItemToCartItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResponseCartItemDto> getCartItemById(Long id) {
        return cartItemRepository.findById(id)
                .map(CART_ITEM_MAPPER::cartItemToCartItemDto);
    }

    @Override
    public ResponseCartItemDto orderItem(ResponseCartItemDto item) {
        CartItem cartItem = CART_ITEM_MAPPER.cartItemDtoToCartItem(item);
        return CART_ITEM_MAPPER.cartItemToCartItemDto(cartItemRepository.save(cartItem));
    }
}
