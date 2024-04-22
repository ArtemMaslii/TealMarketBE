package com.tealmarket.artem.backendService.dto.product.details;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseStorageSpaceDto {

    private Long id;

    private String capacity;
}
