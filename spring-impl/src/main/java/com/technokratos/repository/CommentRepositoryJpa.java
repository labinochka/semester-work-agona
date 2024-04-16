package com.technokratos.repository;

import com.technokratos.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CommentRepositoryJpa extends JpaRepository<CommentEntity, UUID> {

    @Override
    <S extends CommentEntity> S save(S entity);


    @Override
    List<CommentEntity> findAll();

    List<CommentEntity> findByAuthorUsername(String username);

    @Query("select comment.author.username from CommentEntity comment where comment.uuid = :uuid")
    Optional<String> findAuthorUsernameByCommentId(@Param("uuid") UUID uuid);

    @Query("select comment.post.title from CommentEntity comment where comment.uuid = :uuid")
    Optional<String> findPostTitleByCommentId(@Param("uuid") UUID uuid);

    @Override
    Optional<CommentEntity> findById(UUID uuid);

    @Override
    void delete(CommentEntity entity);
}


