package com.technokratos.exception;

import java.util.UUID;

public class PostNotFoundException extends NotFoundServiceException {

    public PostNotFoundException(UUID uuid) {
        super("Post with id = %s - not found".formatted(uuid));
    }
}
