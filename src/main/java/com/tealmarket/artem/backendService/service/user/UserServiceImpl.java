package com.tealmarket.artem.backendService.service.user;

import com.tealmarket.artem.backendService.dto.user.ResponseUserDto;
import com.tealmarket.artem.backendService.model.user.User;
import com.tealmarket.artem.backendService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ResponseUserDto> getUserById(Long id) {
        return userRepository.findById(id)
                .map(USER_MAPPER::userToUserDto);
    }

    @Override
    @Transactional
    public ResponseUserDto registerUser(ResponseUserDto responseUserDto) {
        User user = USER_MAPPER.userDtoToUser(responseUserDto);
        String encodedPassword = passwordEncoder.encode(user.getHashPassword());
        user.setHashPassword(encodedPassword);
        return USER_MAPPER.userToUserDto(userRepository.save(user));
    }
}
