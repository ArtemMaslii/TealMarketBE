package com.tealmarket.artem.backendService.service.cartItem;

import com.tealmarket.artem.backendService.dto.cartItem.ResponseCartItemDto;
import com.tealmarket.artem.backendService.model.cart.Cart;
import com.tealmarket.artem.backendService.model.cart.CartItem;
import com.tealmarket.artem.backendService.model.product.Product;
import com.tealmarket.artem.backendService.repository.CartItemRepository;
import com.tealmarket.artem.backendService.repository.CartRepository;
import com.tealmarket.artem.backendService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartItemServiceImpl implements CartItemService {

    private static final CartItemMapper CART_ITEM_MAPPER = CartItemMapper.INSTANCE;

    private final CartItemRepository cartItemRepository;

    private final ProductRepository productRepository;

    private final CartRepository cartRepository;

    @Override
    public List<ResponseCartItemDto> getOrderedItems(Long id) {
        Optional<Cart> cart = cartRepository.findById(id);
        return cart.map(value -> cartItemRepository.findAllByCart(value).stream()
                .map(CART_ITEM_MAPPER::cartItemToCartItemDto)
                .collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    @Override
    @Transactional
    public Optional<ResponseCartItemDto> orderItem(ResponseCartItemDto item) {
        CartItem cartItem = CART_ITEM_MAPPER.cartItemDtoToCartItem(item);
        Optional<Cart> cart = cartRepository.findById(cartItem.getCart().getId());
        Optional<Product> product = productRepository.findById(cartItem.getProduct().getId());
        if (cart.isPresent() && product.isPresent()) {
            cartItem.setCart(cart.get());
            cartItem.setProduct(product.get());
            return Optional.of(CART_ITEM_MAPPER.cartItemToCartItemDto(cartItemRepository.save(cartItem)));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void deleteItemById(Long id) {
        cartItemRepository.findById(id)
                .ifPresentOrElse(
                        item -> cartItemRepository.deleteById(id),
                        () -> {
                            throw new NoSuchElementException("Item with ID " + id + " not found");
                        }
                );
    }
}
