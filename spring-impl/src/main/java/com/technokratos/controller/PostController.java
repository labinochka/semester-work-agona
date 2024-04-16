package com.technokratos.controller;

import com.technokratos.api.PostApi;
import com.technokratos.dto.request.PostRequest;
import com.technokratos.dto.response.PostResponse;
import com.technokratos.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PostController implements PostApi {

    private final PostService service;

    @Override
    public PostResponse getById(UUID uuid) {
        return service.getById(uuid);
    }

    @Override
    public List<PostResponse> getAll() {
        return service.getAll();
    }

    @Override
    public UUID create(PostRequest postRequest, UUID authorUuid) {
        return service.create(postRequest, authorUuid);
    }
    @Override
    public void deleteById(UUID uuid) {
        service.deleteById(uuid);
    }

    @Override
    public UUID updatePartial(UUID uuid, PostRequest postRequest) {
        return service.updatePartial(uuid, postRequest);
    }
}
