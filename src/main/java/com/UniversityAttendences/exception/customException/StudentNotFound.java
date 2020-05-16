package com.UniversityAttendences.exception.customException;

import com.UniversityAttendences.exception.SystemException;
import org.springframework.http.HttpStatus;

public class StudentNotFound extends SystemException {

    private static final HttpStatus status = HttpStatus.NOT_FOUND;

    public StudentNotFound(String message){
        super(status, message);
    }

    public StudentNotFound(String message, Throwable cause){
        super(status, message, cause);
    }

}
