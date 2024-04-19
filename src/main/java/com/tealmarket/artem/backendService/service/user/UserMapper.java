package com.tealmarket.artem.backendService.service.user;

import com.tealmarket.artem.backendService.dto.user.ResponseUserDto;
import com.tealmarket.artem.backendService.model.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    ResponseUserDto userToUserDto(User user);

    User userDtoToUser(ResponseUserDto userDto);
}
