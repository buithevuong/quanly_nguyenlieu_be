package com.thuctapcdit.qlnguyenlieube.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.thuctapcdit.qlnguyenlieube.dto.ExceptionResponse;

@RestControllerAdvice
public class RestExceptionHandler {

//	@ExceptionHandler(Exception.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public ResponseEntity<?> handlerException(Exception ex){
//        return ResponseEntity.ok(ExceptionResponse.responseFail(ex.getMessage(),HttpStatus.BAD_REQUEST.value()));
//    }

}
