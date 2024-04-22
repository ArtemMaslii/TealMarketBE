package com.tealmarket.artem.backendService.service.user;

import com.tealmarket.artem.backendService.dto.user.ResponseUserDto;

import java.util.Optional;

public interface UserService {

    Optional<ResponseUserDto> authenticate(String email, String password);

    ResponseUserDto registerUser(ResponseUserDto responseUserDto);

    ResponseUserDto updateUser(ResponseUserDto user, Long id);
}
