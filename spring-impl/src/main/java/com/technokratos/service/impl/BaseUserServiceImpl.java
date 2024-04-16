package com.technokratos.service.impl;

import com.technokratos.dto.request.UserRequest;
import com.technokratos.dto.response.UserResponse;
import com.technokratos.exception.UserNotFoundException;
import com.technokratos.mapper.UserMapper;
import com.technokratos.repository.UserRepository;
import com.technokratos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class BaseUserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserResponse getById(UUID uuid) {
        return mapper.toResponse(
                repository.findById(uuid)
                        .orElseThrow(() -> new UserNotFoundException(uuid))
        );
    }

    @Override
    public List<UserResponse> getAll() {
        return mapper.toResponse(repository.getAll());
    }

    @Override
    public UUID create(UserRequest userRequest) {
        return repository.create(mapper.toEntity(userRequest));
    }

    @Override
    public void deleteById(UUID uuid) {
        repository.deleteById(
                repository.findById(uuid)
                        .orElseThrow(() -> new UserNotFoundException(uuid))
                        .getUuid());
    }

    @Override
    public UUID update(UUID uuid, UserRequest userRequest) {
        return repository.update(
                repository.findById(uuid)
                        .orElseThrow(() -> new UserNotFoundException(uuid))
                        .getUuid(), mapper.toEntity(userRequest));
    }

    @Override
    public UUID updatePartial(UUID uuid, UserRequest userRequest) {
        return repository.updatePartial(
                repository.findById(uuid)
                        .orElseThrow(() -> new UserNotFoundException(uuid))
                        .getUuid(), mapper.toEntity(userRequest));
    }
}
