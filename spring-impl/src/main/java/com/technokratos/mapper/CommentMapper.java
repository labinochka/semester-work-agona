package com.technokratos.mapper;

import com.technokratos.dto.request.CommentRequest;
import com.technokratos.dto.response.CommentResponse;
import com.technokratos.model.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PostMapper.class, UserMapper.class})
public interface CommentMapper {

    @Mapping(target = "uuid", ignore = true)
    CommentEntity toEntity(CommentRequest commentRequest);

    CommentResponse toResponse(CommentEntity commentEntity);

    List<CommentResponse> toResponse(List<CommentEntity> commentEntity);
}
