package com.tealmarket.artem.backendService.controller;

import com.tealmarket.artem.backendService.dto.cartItem.ResponseCartItemDto;
import com.tealmarket.artem.backendService.service.cartItem.CartItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cartItem")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://tealmarket-real-prototype.s3-website.eu-north-1.amazonaws.com")
@Validated
public class CartItemController {

    private final CartItemService cartItemService;

    @GetMapping("/{id}")
    public List<ResponseCartItemDto> getOrderedItems(@PathVariable Long id) {
        return cartItemService.getOrderedItems(id);
    }

    @PostMapping
    public ResponseEntity<?> orderItem(@Valid @RequestBody ResponseCartItemDto cartItemDto) {
        Optional<ResponseCartItemDto> responseCartItemDto = cartItemService.orderItem(cartItemDto);
        if (responseCartItemDto.isPresent()) {
            return ResponseEntity.ok(responseCartItemDto.get());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByItemId(@PathVariable Long id) {
        cartItemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }
}
