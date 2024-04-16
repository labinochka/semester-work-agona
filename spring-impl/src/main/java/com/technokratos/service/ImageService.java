package com.technokratos.service;

import com.technokratos.dto.request.ImageRequest;
import com.technokratos.dto.response.ImageResponse;

import java.util.UUID;

public interface ImageService {

    ImageResponse getByPostId(UUID uuid);

    UUID create(UUID postUuid, ImageRequest imageRequest);

    void deleteById(UUID uuid);
}
