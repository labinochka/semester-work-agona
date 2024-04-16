package com.technokratos.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "Модель для получения User")
public record UserResponse(
        @ApiModelProperty(value = "юзернейм") String username,
        @ApiModelProperty(value = "имя") String name,
        @ApiModelProperty(value = "фамилия") String lastname,
        @ApiModelProperty(value = "электронная почта") String email,
        @ApiModelProperty(value = "посты юзера") List<ShortInfoPostResponse> authorPosts,
        @ApiModelProperty(value = "комментируемые юзером посты") List<PostResponse> commentPosts,
        @ApiModelProperty(value = "комментарии юзера") List<CommentResponse> comments
) {
}
