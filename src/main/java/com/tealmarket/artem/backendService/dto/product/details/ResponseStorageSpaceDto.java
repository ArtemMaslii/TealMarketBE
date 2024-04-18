package com.tealmarket.artem.backendService.dto.product.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStorageSpaceDto {

    private String capacity;
}
