package com.technokratos.mapper;

import com.technokratos.dto.request.PostRequest;
import com.technokratos.dto.response.PostResponse;
import com.technokratos.dto.response.ShortInfoPostResponse;
import com.technokratos.model.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CommentMapper.class, ImageMapper.class})
public interface PostMapper {

    @Mapping(target = "uuid", ignore = true)
    PostEntity toEntity(PostRequest postRequest);

    PostResponse toResponse(PostEntity postEntity);

    List<PostResponse> toResponse(List<PostEntity> postEntities);

    ShortInfoPostResponse toShortInfoPostResponse(PostEntity userEntity);
}
