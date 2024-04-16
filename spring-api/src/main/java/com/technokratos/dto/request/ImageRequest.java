package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для создания Image")
public record ImageRequest(
        @ApiModelProperty(value = "ссылка на изображение") String imageUrl
) {
}
