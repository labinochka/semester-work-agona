package com.technokratos.repository.impl;

import com.technokratos.model.CommentEntity;
import com.technokratos.repository.CommentRepository;
import com.technokratos.repository.PostRepository;
import com.technokratos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryJpaImpl implements CommentRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    @Override
    public List<CommentEntity> getByPostId(UUID uuid) {
        TypedQuery<CommentEntity> query = entityManager.createQuery("select comment from CommentEntity comment " +
                        "where comment.post.uuid = :uuid", CommentEntity.class);
        query.setParameter("uuid", uuid);
        return query.getResultList();
    }

    @Override
    public UUID create(UUID postUuid, UUID authorUuid, CommentEntity entity) {
        UUID uuid = UUID.randomUUID();
        entity.setUuid(uuid);
        entity.setAuthor(userRepository.findById(authorUuid).get());
        entity.setPost(postRepository.findById(postUuid).get());
        entityManager.merge(entity);
        return uuid;
    }

    @Override
    public Optional<CommentEntity> findById(UUID uuid) {
        CommentEntity comment = entityManager.find(CommentEntity.class, uuid);
        return Optional.ofNullable(comment);
    }

    @Override
    public void deleteById(UUID uuid) {
        entityManager.remove(findById(uuid).get());
    }

    @Override
    public UUID update(UUID uuid, CommentEntity entity) {
        CommentEntity comment = findById(uuid).get();
        comment.setContent(entity.getContent());
        entityManager.merge(comment);
        return uuid;
    }
}
