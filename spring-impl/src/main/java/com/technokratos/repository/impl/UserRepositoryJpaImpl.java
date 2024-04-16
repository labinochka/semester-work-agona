package com.technokratos.repository.impl;

import com.technokratos.exception.UserNotUpdateException;
import com.technokratos.model.PostEntity;
import com.technokratos.model.UserEntity;
import com.technokratos.repository.PostRepository;
import com.technokratos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepositoryJpaImpl implements UserRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Optional<UserEntity> findById(UUID uuid) {
        UserEntity user = entityManager.find(UserEntity.class, uuid);
        return Optional.ofNullable(user);
    }

    @Override
    public List<UserEntity> getAll() {
        TypedQuery<UserEntity> query = entityManager.createQuery("select user from UserEntity user",
                UserEntity.class);
        return query.getResultList();
    }

    @Override
    public UUID create(UserEntity userEntity) {
        UUID uuid = UUID.randomUUID();
        userEntity.setUuid(uuid);
        entityManager.merge(userEntity);
        return uuid;
    }

    @Override
    public void deleteById(UUID uuid) {
        List<PostEntity> posts = entityManager.find(UserEntity.class, uuid).getAuthorPosts();
        for (PostEntity post: posts) {
            postRepository.deleteById(post.getUuid());
        }
    }

    @Override
    public UUID update(UUID uuid, UserEntity userEntity) {
        if (userEntity.getUsername() == null || userEntity.getName() == null || userEntity.getLastname() == null ||
                userEntity.getEmail() == null || userEntity.getPassword() == null) {
            throw new UserNotUpdateException(uuid);
        }
        entityManager.merge(userEntity);
        return uuid;
    }

    @Override
    public UUID updatePartial(UUID uuid, UserEntity userEntity) {
        UserEntity user = entityManager.find(UserEntity.class, uuid);

        if (userEntity.getUsername() != null) {
            user.setUsername(userEntity.getUsername());
        } if (userEntity.getName() != null) {
            user.setName(userEntity.getName());
        } if (userEntity.getLastname() != null) {
            user.setLastname(userEntity.getLastname());
        } if (userEntity.getEmail() != null) {
            user.setEmail(userEntity.getEmail());
        } if (userEntity.getPassword() != null) {
            user.setPassword(userEntity.getPassword());
        }
        entityManager.merge(userEntity);
        return uuid;
    }
}
