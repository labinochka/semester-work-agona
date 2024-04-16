package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для создания Post")
public record PostRequest(
        @ApiModelProperty(value = "название") String title,
        @ApiModelProperty(value = "контент") String content
) {
}
