package com.tealmarket.artem.backendService.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAddressDto {

    private String country;

    private String city;

    private String street;

    private String postCode;
}
