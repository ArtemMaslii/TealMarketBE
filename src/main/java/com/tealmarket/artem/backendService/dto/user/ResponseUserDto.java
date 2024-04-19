package com.tealmarket.artem.backendService.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDto {

    @JsonIgnore
    private Long id;

    private String email;

    private String hashPassword;

    private ResponseAddressDto address;
}
