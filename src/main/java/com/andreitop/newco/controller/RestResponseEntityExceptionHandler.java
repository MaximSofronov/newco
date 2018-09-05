package com.andreitop.newco.controller;

import com.andreitop.newco.dto.ApiErrorDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

    private final String notValidArgument = "Not valid argument";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final ApiErrorDto apiErrorDto = new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), notValidArgument);

        return handleExceptionInternal(ex, apiErrorDto, headers, HttpStatus.BAD_REQUEST, request);
    }

}
