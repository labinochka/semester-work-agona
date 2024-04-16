package com.technokratos.repository;

import com.technokratos.model.CommentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentRepository {

    List<CommentEntity> getByPostId(UUID uuid);

    UUID create(UUID postUuid, UUID authorUuid, CommentEntity entity);

    Optional<CommentEntity> findById(UUID uuid);

    void deleteById(UUID uuid);

    UUID update(UUID uuid, CommentEntity entity);
}
