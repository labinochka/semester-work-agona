package com.technokratos.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для создания Comment")
public record CommentRequest(
        @ApiModelProperty(value = "контент") String content
) {
}
