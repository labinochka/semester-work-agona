package com.technokratos.repository.impl;

import com.technokratos.model.PostEntity;
import com.technokratos.repository.PostRepository;
import com.technokratos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostRepositoryJpaImpl implements PostRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<PostEntity> findById(UUID uuid) {
        PostEntity post = entityManager.find(PostEntity.class, uuid);
        return Optional.ofNullable(post);
    }

    @Override
    public List<PostEntity> getAll() {
        TypedQuery<PostEntity> query = entityManager.createQuery("select post from PostEntity post",
                PostEntity.class);
        return query.getResultList();
    }

    @Override
    public UUID create(PostEntity entity, UUID authorUuid) {
        UUID uuid = UUID.randomUUID();
        entity.setUuid(uuid);
        entity.setAuthor(userRepository.findById(authorUuid).get());
        entityManager.merge(entity);
        return uuid;
    }

    @Override
    public void deleteById(UUID uuid) {
        Query queryImage = entityManager.createQuery("delete from ImageEntity image where " +
                "image.post.uuid = :uuid");
        queryImage.setParameter("uuid", uuid);
        queryImage.executeUpdate();

        Query queryComment = entityManager.createQuery("delete from CommentEntity comment where " +
                "comment.post.uuid = :uuid");
        queryComment.setParameter("uuid", uuid);
        queryComment.executeUpdate();

        Query queryPost = entityManager.createQuery("delete from PostEntity post where post.uuid = :uuid");
        queryPost.setParameter("uuid", uuid);
        queryPost.executeUpdate();

    }

    @Override
    public UUID updatePartial(UUID uuid, PostEntity entity) {
        PostEntity post = entityManager.find(PostEntity.class, uuid);

        if (entity.getTitle() != null) {
            post.setTitle(entity.getTitle());
        }
        if (entity.getContent() != null) {
            post.setContent(entity.getContent());
        }
        entityManager.merge(post);
        return uuid;
    }
}
