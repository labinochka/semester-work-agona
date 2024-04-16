package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для создания User")
public record UserRequest(
        @ApiModelProperty(value = "юзернейм") String username,
        @ApiModelProperty(value = "имя") String name,
        @ApiModelProperty(value = "фамилия") String lastname,
        @ApiModelProperty(value = "электронная почта") String email,
        @ApiModelProperty(value = "пароль") String password
) {
}
