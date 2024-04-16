package com.technokratos.service.impl;

import com.technokratos.dto.request.CommentRequest;
import com.technokratos.dto.response.CommentResponse;
import com.technokratos.exception.CommentNotFoundException;
import com.technokratos.mapper.CommentMapper;
import com.technokratos.model.CommentEntity;
import com.technokratos.repository.CommentRepository;
import com.technokratos.service.CommentService;
import com.technokratos.service.PostService;
import com.technokratos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;

    private final PostService postService;
    private final UserService userService;

    @Override
    public List<CommentResponse> getByPostId(UUID uuid) {
        List<CommentResponse> commentResponses = new ArrayList<>();
        if (postService.getById(uuid) != null) {
            List<CommentEntity> commentEntities = repository.getByPostId(uuid);
            for (CommentEntity commentEntity : commentEntities) {
                commentResponses.add(mapper.toResponse(commentEntity));
            }
        }
        return commentResponses;
    }

    @Override
    public UUID create(UUID postUuid, UUID authorUuid, CommentRequest commentRequest) {
        UUID uuid = null;
        if (postService.getById(postUuid) != null && userService.getById(authorUuid) != null) {
            uuid = repository.create(postUuid, authorUuid, mapper.toEntity(commentRequest));
        }
        return uuid;
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(
                repository.findById(uuid)
                        .orElseThrow(() -> new CommentNotFoundException(uuid))
                        .getUuid()
        );
    }

    @Override
    public UUID update(UUID uuid, CommentRequest commentRequest) {
        return repository.update(
                repository.findById(uuid)
                        .orElseThrow(() -> new CommentNotFoundException(uuid))
                        .getUuid(), mapper.toEntity(commentRequest)
        );
    }
}
