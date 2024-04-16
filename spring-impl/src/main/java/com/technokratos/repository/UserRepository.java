package com.technokratos.repository;

import com.technokratos.model.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<UserEntity> findById(UUID uuid);

    List<UserEntity> getAll();

    UUID create(UserEntity userEntity);

    void deleteById(UUID uuid);

    UUID update(UUID uuid, UserEntity userEntity);

    UUID updatePartial(UUID uuid, UserEntity userEntity);
}
