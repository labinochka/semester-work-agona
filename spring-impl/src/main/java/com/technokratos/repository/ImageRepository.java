package com.technokratos.repository;

import com.technokratos.model.ImageEntity;

import java.util.Optional;
import java.util.UUID;

public interface ImageRepository {

    Optional<ImageEntity> getByPostId(UUID uuid);

    UUID create(UUID postUuid, ImageEntity entity);

    Optional<ImageEntity> getById(UUID uuid);

    void deleteById(UUID uuid);
}
