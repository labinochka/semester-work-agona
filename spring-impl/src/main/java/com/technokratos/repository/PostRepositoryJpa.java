package com.technokratos.repository;

import com.technokratos.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepositoryJpa extends JpaRepository<PostEntity, UUID> {

    @Override
    <S extends PostEntity> S save(S entity);

    Optional<PostEntity> findByAuthorUsername(String username);

    @Override
    List<PostEntity> findAll();

    @Query("select post.author.username from PostEntity post where post.uuid = :uuid")
    Optional<String> findAuthorUsernameByPostId(@Param("uuid") UUID uuid);

    @Query("select comment.content from CommentEntity comment where comment.post.uuid = :uuid")
    List<String> findCommentContentsByPostId(@Param("uuid") UUID uuid);

    @Override
    Optional<PostEntity> findById(UUID uuid);

    @Override
    void delete(PostEntity entity);
}


