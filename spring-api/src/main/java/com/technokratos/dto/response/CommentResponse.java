package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Модель для получения Comment")
public record CommentResponse(
        @ApiModelProperty(value = "автор") AuthorCommentResponse author,
        @ApiModelProperty(value = "контент") String content
) {
}
