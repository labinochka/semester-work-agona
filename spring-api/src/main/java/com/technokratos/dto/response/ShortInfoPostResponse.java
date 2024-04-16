package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для получения краткой информации о посте")
public record ShortInfoPostResponse(
        @ApiModelProperty(value = "название") String title,
        @ApiModelProperty(value = "изображение") ImageResponse image
) {
}
