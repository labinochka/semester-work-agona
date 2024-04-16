package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для получения Image")
public record ImageResponse(
        @ApiModelProperty(value = "ссылка на изображение") String imageUrl

) {
}
