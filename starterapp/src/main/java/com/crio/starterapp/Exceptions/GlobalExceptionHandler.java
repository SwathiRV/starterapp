package com.crio.starterapp.Exceptions;

import com.crio.starterapp.Exchange.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InValidScoreEcxception.class)
    public ResponseEntity<ApiResponse> invalidScoreHandler(Exception exception){
        String message = exception.getMessage();
        ApiResponse apiResponse = ApiResponse.builder().message(message).status(HttpStatus.BAD_REQUEST).success(true).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

}
