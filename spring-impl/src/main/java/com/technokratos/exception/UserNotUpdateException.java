package com.technokratos.exception;

import java.util.UUID;

public class UserNotUpdateException extends NotUpdateServiceException {

    public UserNotUpdateException(UUID uuid) {
        super("User with id = %s - not update. Not all data is entered".formatted(uuid));
    }
}
