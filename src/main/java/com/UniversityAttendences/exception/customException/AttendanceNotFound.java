package com.UniversityAttendences.exception.customException;

import com.UniversityAttendences.exception.SystemException;
import org.springframework.http.HttpStatus;

public class AttendanceNotFound extends SystemException {

    private static final HttpStatus status = HttpStatus.NOT_FOUND;

    public AttendanceNotFound(String message){
        super(status, message);
    }

    public AttendanceNotFound(String message, Throwable cause){
        super(status, message, cause);
    }

}
