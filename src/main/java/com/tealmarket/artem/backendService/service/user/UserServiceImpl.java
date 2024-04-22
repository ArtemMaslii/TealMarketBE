package com.tealmarket.artem.backendService.service.user;

import com.tealmarket.artem.backendService.dto.user.ResponseUserDto;
import com.tealmarket.artem.backendService.model.cart.Cart;
import com.tealmarket.artem.backendService.model.user.Address;
import com.tealmarket.artem.backendService.model.user.User;
import com.tealmarket.artem.backendService.model.user.UserRole;
import com.tealmarket.artem.backendService.repository.CartRepository;
import com.tealmarket.artem.backendService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private static final UserMapper USER_MAPPER = UserMapper.INSTANCE;

    private final UserRepository userRepository;

    private final CartRepository cartRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ResponseUserDto> authenticate(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if(passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(USER_MAPPER.userToUserDto(user));
            }
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public ResponseUserDto registerUser(ResponseUserDto responseUserDto) {
        User user = USER_MAPPER.userDtoToUser(responseUserDto);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(UserRole.USER);

        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);

        User savedUser = userRepository.save(user);
        Cart savedCart = cartRepository.save(cart);

        savedUser.setCart(savedCart);

        return USER_MAPPER.userToUserDto(savedUser);
    }

    @Override
    @Transactional
    public ResponseUserDto updateUser(ResponseUserDto user, Long id) {
        User existingUser = userRepository.findById(id).get();
        if (existingUser == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        User updatedUser = userRepository.save(copyProperties(user, existingUser));
        ResponseUserDto responseUserDto = USER_MAPPER.userToUserDto(updatedUser);
        return responseUserDto;
    }

    private User copyProperties(ResponseUserDto user, User existingUser) {
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        Cart cart = new Cart();
        cart.setId(user.getCart().getId());
        cart.setUser(existingUser);
        existingUser.setCart(cart);
        Address address = new Address();
        address.setCountry(user.getAddress().getCountry());
        address.setCity(user.getAddress().getCity());
        address.setStreet(user.getAddress().getStreet());
        address.setPostCode(user.getAddress().getPostCode());
        existingUser.setAddress(address);
        return existingUser;
    }
}
