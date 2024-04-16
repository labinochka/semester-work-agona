package com.technokratos.exception;

import java.util.UUID;

public class CommentNotFoundException extends NotFoundServiceException {

    public CommentNotFoundException(UUID uuid) {
        super("Comment with id = %s - not found".formatted(uuid));
    }
}
