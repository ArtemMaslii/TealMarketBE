package com.tealmarket.artem.backendService.controller;

import com.tealmarket.artem.backendService.dto.user.LoginRequest;
import com.tealmarket.artem.backendService.dto.user.ResponseUserDto;
import com.tealmarket.artem.backendService.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://tealmarket-real-prototype.s3-website.eu-north-1.amazonaws.com")
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> getUserById(@Valid @RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        Optional<ResponseUserDto> user = userService.authenticate(email, password);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseUserDto> registerUser(@Valid @RequestBody ResponseUserDto responseUserDto) {
        ResponseUserDto userDto = userService.registerUser(responseUserDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDto.getId())
                .toUri();
        return ResponseEntity.created(location).body(userDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseUserDto> updateUser(@Valid @RequestBody ResponseUserDto user, @PathVariable Long id) {
        ResponseUserDto updatedUser = userService.updateUser(user, id);
        return ResponseEntity.ok(updatedUser);
    }
}
