package com.technokratos.service.impl;

import com.technokratos.dto.request.PostRequest;
import com.technokratos.dto.response.PostResponse;
import com.technokratos.exception.PostNotFoundException;
import com.technokratos.mapper.PostMapper;
import com.technokratos.repository.PostRepository;
import com.technokratos.service.PostService;
import com.technokratos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final PostMapper mapper;

    private final UserService userService;

    @Override
    public PostResponse getById(UUID uuid) {
        return mapper.toResponse(
                repository.findById(uuid)
                        .orElseThrow(() -> new PostNotFoundException(uuid))
        );
    }

    @Override
    public List<PostResponse> getAll() {
        return mapper.toResponse(repository.getAll());
    }

    @Override
    public UUID create(PostRequest postRequest, UUID authorUuid) {
        UUID uuid = null;
        if (userService.getById(authorUuid) != null) {
            uuid = repository.create(mapper.toEntity(postRequest), authorUuid);
        }
        return uuid;
    }

    @Override
    public void deleteById(UUID uuid) {
        if (repository.findById(uuid).isPresent()) {
            repository.deleteById(uuid);
        }
        else {
            throw new PostNotFoundException(uuid);
        }
    }

    @Override
    public UUID updatePartial(UUID uuid, PostRequest postRequest) {
        return repository.updatePartial(
                repository.findById(uuid)
                        .orElseThrow(() -> new PostNotFoundException(uuid))
                        .getUuid(), mapper.toEntity(postRequest));
    }
}
