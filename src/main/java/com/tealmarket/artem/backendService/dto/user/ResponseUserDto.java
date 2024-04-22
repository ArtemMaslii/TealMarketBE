package com.tealmarket.artem.backendService.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tealmarket.artem.backendService.dto.cartItem.ResponseCartDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDto {

    private Long id;

    private String username;

    private String email;

    private String password;

    private ResponseAddressDto address;

    private ResponseCartDto cart;
}
