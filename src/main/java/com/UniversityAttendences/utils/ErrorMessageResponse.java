package com.UniversityAttendences.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessageResponse {

    private String message;
    private HttpStatus httpStatus;
    private String httpStatusCode;
    private Throwable cause;
    private String date;

    public ErrorMessageResponse(String message) {
        this.message = message;
        this.date = LocalDateTime.now().toString();
    }

    public ErrorMessageResponse(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
        this.date = LocalDateTime.now().toString();
    }

    public ErrorMessageResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.getReasonPhrase();
        this.date = LocalDateTime.now().toString();
    }

    public ErrorMessageResponse(String message, HttpStatus httpStatus, Throwable cause) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.getReasonPhrase();
        this.cause = cause;
        this.date = LocalDateTime.now().toString();
    }
}