package com.UniversityAttendences.exception.customException;

import com.UniversityAttendences.exception.SystemException;
import org.springframework.http.HttpStatus;

public class SubjectNotFound extends SystemException {

    private static final HttpStatus status = HttpStatus.NOT_FOUND;

    public SubjectNotFound(String message){
        super(status, message);
    }

    public SubjectNotFound(String message, Throwable cause){
        super(status, message, cause);
    }

}
