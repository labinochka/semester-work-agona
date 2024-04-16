package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для получения профиля")
public record ProfileResponse(
        @ApiModelProperty(value = "юзернейм") String username,
        @ApiModelProperty(value = "имя") String name,
        @ApiModelProperty(value = "фамилия") String lastname
) {
}
