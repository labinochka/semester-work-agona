package com.technokratos.repository;

import com.technokratos.model.PostEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository  {
    Optional<PostEntity> findById(UUID uuid);

    List<PostEntity> getAll();

    UUID create(PostEntity entity, UUID authorUuid);

    void deleteById(UUID uuid);

    UUID updatePartial(UUID uuid, PostEntity entity);
}
