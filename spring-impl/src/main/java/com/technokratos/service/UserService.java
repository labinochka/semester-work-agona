package com.technokratos.service;

import com.technokratos.dto.request.UserRequest;
import com.technokratos.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    
    UserResponse getById(UUID uuid);

    List<UserResponse> getAll();

    UUID create(UserRequest userRequest);

    void deleteById(UUID uuid);

    UUID update(UUID uuid, UserRequest userRequest);

    UUID updatePartial(UUID uuid, UserRequest userRequest);
}
