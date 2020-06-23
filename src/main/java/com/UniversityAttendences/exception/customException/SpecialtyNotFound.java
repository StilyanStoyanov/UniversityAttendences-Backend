package com.UniversityAttendences.exception.customException;

import com.UniversityAttendences.exception.SystemException;
import org.springframework.http.HttpStatus;

public class SpecialtyNotFound extends SystemException {

    private static final HttpStatus status = HttpStatus.NOT_FOUND;

    public SpecialtyNotFound(String message){
        super(status, message);
    }

    public SpecialtyNotFound(String message, Throwable cause){
        super(status, message, cause);
    }

}
