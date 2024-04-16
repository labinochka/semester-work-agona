package com.technokratos.controller;

import com.technokratos.api.ImageApi;
import com.technokratos.dto.request.ImageRequest;
import com.technokratos.dto.response.ImageResponse;
import com.technokratos.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ImageController implements ImageApi {

    private final ImageService service;

    @Override
    public ImageResponse getByPostId(UUID uuid) {
        return service.getByPostId(uuid);
    }

    @Override
    public UUID create(UUID postUuid, ImageRequest imageRequest) {
        return service.create(postUuid, imageRequest);
    }

    @Override
    public void deleteById(UUID uuid) {
        service.deleteById(uuid);
    }
}
