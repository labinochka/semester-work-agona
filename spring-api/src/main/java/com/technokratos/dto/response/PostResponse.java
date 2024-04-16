package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "Модель для получения Post")
public record PostResponse(
        @ApiModelProperty(value = "название") String title,
        @ApiModelProperty(value = "контент") String content,
        @ApiModelProperty(value = "автор") ProfileResponse author,
        @ApiModelProperty(value = "изображение") ImageResponse image,
        @ApiModelProperty(value = "комментаторы") List<ProfileResponse> commentUsers,
        @ApiModelProperty(value = "комментарии") List<CommentResponse> comments
) {
}
