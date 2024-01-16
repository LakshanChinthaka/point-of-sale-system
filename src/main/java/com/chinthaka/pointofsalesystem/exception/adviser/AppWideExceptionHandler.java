package com.chinthaka.pointofsalesystem.exception.adviser;

import com.chinthaka.pointofsalesystem.exception.NotFoundException;
import com.chinthaka.pointofsalesystem.exception.ResourceAlreadyExistException;
import com.chinthaka.pointofsalesystem.exception.UserAlreadyExistException;
import com.chinthaka.pointofsalesystem.exception.ValidationException;
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

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handlerNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        400,"Error",e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<StandardResponse> handelValidationException(ValidationException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(400,"Error",e.getMessage()),HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<StandardResponse> handelResourceAlreadyExistException(ResourceAlreadyExistException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(400,"Error",e.getMessage()),HttpStatus.BAD_REQUEST
        );
    }
}
