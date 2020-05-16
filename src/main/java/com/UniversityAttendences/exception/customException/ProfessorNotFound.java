package com.UniversityAttendences.exception.customException;

import com.UniversityAttendences.exception.SystemException;
import org.springframework.http.HttpStatus;

public class ProfessorNotFound extends SystemException {

    private static final HttpStatus status = HttpStatus.NOT_FOUND;

    public ProfessorNotFound(String message){
        super(status, message);
    }

    public ProfessorNotFound(String message, Throwable cause){
        super(status, message, cause);
    }

}
