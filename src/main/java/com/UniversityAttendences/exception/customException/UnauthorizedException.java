package com.UniversityAttendences.exception.customException;

import com.UniversityAttendences.exception.SystemException;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends SystemException {

    private static final HttpStatus status = HttpStatus.UNAUTHORIZED;

    public UnauthorizedException(String message){
        super(status, message);
    }

    public UnauthorizedException(String message, Throwable cause){
        super(status, message, cause);
    }

}
