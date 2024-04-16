package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для получения автора комментария")
public record AuthorCommentResponse(
        @ApiModelProperty(value = "юзернейм") String username
) {
}
