package com.technokratos.exception;

import java.util.UUID;

public class ImageWithPostIdNotFoundException extends NotFoundServiceException {

    public ImageWithPostIdNotFoundException(UUID uuid) {
        super("Image on the post with id = %s - not found".formatted(uuid));
    }
}
