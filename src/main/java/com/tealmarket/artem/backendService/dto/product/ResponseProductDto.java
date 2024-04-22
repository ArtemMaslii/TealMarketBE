package com.tealmarket.artem.backendService.dto.product;

import com.tealmarket.artem.backendService.dto.product.details.ResponseColorDto;
import com.tealmarket.artem.backendService.dto.product.details.ResponseStorageSpaceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseProductDto {

    private Long id;

    private String name;

    private Double price;

    private List<ResponseColorDto> colors;

    private List<ResponseStorageSpaceDto> storages;
}
