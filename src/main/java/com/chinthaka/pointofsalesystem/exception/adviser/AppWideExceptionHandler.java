package com.chinthaka.pointofsalesystem.exception.adviser;

import com.chinthaka.pointofsalesystem.exception.UserAlreadyExistException;
import com.chinthaka.pointofsalesystem.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<StandardResponse> handlerUserAlreadyExist(UserAlreadyExistException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        400,"Error",e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
