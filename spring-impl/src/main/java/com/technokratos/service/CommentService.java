package com.technokratos.service;

import com.technokratos.dto.request.CommentRequest;
import com.technokratos.dto.response.CommentResponse;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    
    List<CommentResponse> getByPostId(UUID uuid);

    UUID create(UUID postUuid, UUID authorUuid, CommentRequest commentRequest);

    void deleteById(UUID uuid);

    UUID update(UUID uuid, CommentRequest commentRequest);
}
