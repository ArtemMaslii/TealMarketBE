package com.tealmarket.artem.backendService.service.user;

import com.tealmarket.artem.backendService.dto.user.ResponseUserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<ResponseUserDto> getUserById(Long id);

    ResponseUserDto registerUser(ResponseUserDto responseUserDto);
}
