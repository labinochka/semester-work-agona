package com.technokratos.controller;

import com.technokratos.api.CommentApi;
import com.technokratos.dto.request.CommentRequest;
import com.technokratos.dto.response.CommentResponse;
import com.technokratos.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CommentController implements CommentApi {

    private final CommentService service;

    @Override
    public List<CommentResponse> getByPostId(UUID uuid) {
        return service.getByPostId(uuid);
    }

    @Override
    public UUID create(UUID postUuid, UUID authorUuid, CommentRequest commentRequest) {
        return service.create(postUuid, authorUuid, commentRequest);
    }

    @Override
    public void deleteById(UUID uuid) {
        service.deleteById(uuid);
    }

    @Override
    public UUID update(UUID uuid, CommentRequest commentRequest) {
        return service.update(uuid, commentRequest);
    }
}
