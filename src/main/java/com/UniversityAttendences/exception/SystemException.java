package com.UniversityAttendences.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SystemException extends RuntimeException {

    private HttpStatus httpStatus;

    private String code;

    public SystemException(final HttpStatus status, final String message) {
        super(message);
        this.httpStatus = status;
        this.code = status.getReasonPhrase();
    }

    public SystemException(final HttpStatus status, final String message, final Throwable cause) {
        super(message, cause);
        this.httpStatus = status;
        this.code = status.getReasonPhrase();
    }
}
