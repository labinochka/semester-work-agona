package com.technokratos.controller;

import com.technokratos.api.UserApi;
import com.technokratos.dto.request.UserRequest;
import com.technokratos.dto.response.UserResponse;
import com.technokratos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService service;

    @Override
    public UserResponse getById(UUID uuid) {
        return service.getById(uuid);
    }

    @Override
    public List<UserResponse> getAll() {
        return service.getAll();
    }

    @Override
    public UUID create(UserRequest userRequest) {
        return service.create(userRequest);
    }

    @Override
    public void deleteById(UUID uuid) {
        service.deleteById(uuid);
    }

    @Override
    public UUID update(UUID uuid, UserRequest userRequest) {
        return service.update(uuid, userRequest);
    }

    @Override
    public UUID updatePartial(UUID uuid, UserRequest userRequest) {
        return service.updatePartial(uuid, userRequest);
    }
}
