package com.technokratos.mapper;

import com.technokratos.dto.request.UserRequest;
import com.technokratos.dto.response.AuthorCommentResponse;
import com.technokratos.dto.response.ProfileResponse;
import com.technokratos.dto.response.UserResponse;
import com.technokratos.model.UserEntity;
import liquibase.util.MD5Util;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PostMapper.class, CommentMapper.class})
public interface UserMapper {

    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "password", qualifiedByName = "hashPassword")
    UserEntity toEntity(UserRequest userRequest);

    UserResponse toResponse(UserEntity userEntity);

    List<UserResponse> toResponse(List<UserEntity> userEntities);

    ProfileResponse toProfileResponse(UserEntity userEntity);

    List<ProfileResponse> toProfileResponse(List<UserEntity> userEntity);

    AuthorCommentResponse toAuthorCommentResponse(UserEntity userEntity);

    @Named("hashPassword")
    default String hashPassword(String password) {
        return MD5Util.computeMD5(password);
    }

}

