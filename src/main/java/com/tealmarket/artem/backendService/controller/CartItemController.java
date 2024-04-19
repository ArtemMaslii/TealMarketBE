package com.tealmarket.artem.backendService.controller;

import com.tealmarket.artem.backendService.dto.cartItem.ResponseCartItemDto;
import com.tealmarket.artem.backendService.service.cartItem.CartItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cartItem")
@RequiredArgsConstructor
@Validated
public class CartItemController {

    private final CartItemService cartItemService;

    @GetMapping
    public List<ResponseCartItemDto> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCartItemDto> getCartItemById(@PathVariable Long id) {
        Optional<ResponseCartItemDto> cartItem = cartItemService.getCartItemById(id);
        return cartItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResponseCartItemDto> orderItem(@Valid @RequestBody ResponseCartItemDto cartItemDto) {
        ResponseCartItemDto responseCartItemDto = cartItemService.orderItem(cartItemDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseCartItemDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(responseCartItemDto);
    }
}
