package com.technokratos.service.impl;

import com.technokratos.dto.request.ImageRequest;
import com.technokratos.dto.response.ImageResponse;
import com.technokratos.exception.ImageNotFoundException;
import com.technokratos.exception.ImageWithPostIdNotFoundException;
import com.technokratos.mapper.ImageMapper;
import com.technokratos.repository.ImageRepository;
import com.technokratos.service.ImageService;
import com.technokratos.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;
    private final ImageMapper mapper;

    private final PostService postService;

    @Override
    public ImageResponse getByPostId(UUID uuid) {
        return mapper.toResponse(
                repository.getByPostId(uuid)
                        .orElseThrow(() -> new ImageWithPostIdNotFoundException(uuid))
        );
    }

    @Override
    public UUID create(UUID postUuid, ImageRequest imageRequest) {
        UUID uuid = null;
        if (postService.getById(postUuid) != null) {
            uuid = repository.create(postUuid, mapper.toEntity(imageRequest));
        }
        return uuid;
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(
                repository.getById(uuid)
                        .orElseThrow(() -> new ImageNotFoundException(uuid))
                                .getUuid()
        );
    }
}
