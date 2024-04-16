package com.technokratos.repository;

import com.technokratos.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntity, UUID> {

    @Override
    <S extends UserEntity> S save(S entity);


    @Override
    List<UserEntity> findAll();

    Optional<UserEntity> findByUsername(String username);

    @Override
    Optional<UserEntity> findById(UUID uuid);

    @Query("select comment.content from CommentEntity comment where comment.author.username = :username")
    List<String> findCommentContentByUsername(@Param("username") String username);

    @Query("select post.title from PostEntity post where post.author.username = :username")
    Optional<String> findPostTitleByUsername(@Param("username") String username);

    @Override
    void delete(UserEntity entity);
}

