package com.technokratos.exception;

import java.util.UUID;

public class ImageNotFoundException extends NotFoundServiceException {

    public ImageNotFoundException(UUID uuid) {
        super("Image with id = %s - not found".formatted(uuid));
    }
}
