package com.UniversityAttendences.exception.customException;

import com.UniversityAttendences.exception.SystemException;
import org.springframework.http.HttpStatus;

public class ProgramNotFound extends SystemException {

    private static final HttpStatus status = HttpStatus.NOT_FOUND;

    public ProgramNotFound(String message){
        super(status, message);
    }

    public ProgramNotFound(String message, Throwable cause){
        super(status, message, cause);
    }

}
