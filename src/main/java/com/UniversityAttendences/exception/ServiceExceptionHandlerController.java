package com.UniversityAttendences.exception;

import com.UniversityAttendences.exception.customException.UnauthorizedException;
import com.UniversityAttendences.utils.ErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ServiceExceptionHandlerController extends ResponseEntityExceptionHandler{

    @ExceptionHandler({Exception.class})
    private ResponseEntity<ErrorMessageResponse> handleUnexpectedException (Exception e){
        return new ResponseEntity<>(new ErrorMessageResponse(e.getMessage(), e.getCause()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({SystemException.class})
    private ResponseEntity<ErrorMessageResponse> handleSystemException (SystemException e){
        return new ResponseEntity<>(new ErrorMessageResponse(e.getMessage(), e.getCause()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({UnauthorizedException.class})
    private ResponseEntity<ErrorMessageResponse> handleSystemException (UnauthorizedException e){
        return new ResponseEntity<>(new ErrorMessageResponse(e.getMessage(),e.getHttpStatus(), e.getCause()), HttpStatus.UNAUTHORIZED);
    }
}
