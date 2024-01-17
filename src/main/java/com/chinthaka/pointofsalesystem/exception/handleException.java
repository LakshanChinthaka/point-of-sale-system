package com.chinthaka.pointofsalesystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class handleException extends RuntimeException {

    public handleException(String message) {
        super(message);
    }
}
