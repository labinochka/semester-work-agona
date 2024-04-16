package com.technokratos.service;

import com.technokratos.dto.request.PostRequest;
import com.technokratos.dto.response.PostResponse;

import java.util.List;
import java.util.UUID;

public interface PostService {

    PostResponse getById(UUID uuid);

    List<PostResponse> getAll();

    UUID create(PostRequest postRequest, UUID authorUuid);

    void deleteById(UUID uuid);

    UUID updatePartial(UUID uuid, PostRequest postRequest);
}
