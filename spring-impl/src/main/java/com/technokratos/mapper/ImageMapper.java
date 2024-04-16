package com.technokratos.mapper;

import com.technokratos.dto.request.ImageRequest;
import com.technokratos.dto.response.ImageResponse;
import com.technokratos.model.ImageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    @Mapping(target = "uuid", ignore = true)
    ImageEntity toEntity(ImageRequest imageRequest);

    ImageResponse toResponse(ImageEntity imageEntity);
}
