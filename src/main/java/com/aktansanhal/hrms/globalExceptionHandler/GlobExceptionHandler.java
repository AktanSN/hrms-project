package com.aktansanhal.hrms.globalExceptionHandler;

import com.aktansanhal.hrms.customException.JobSeekerNotValidException;
import com.aktansanhal.hrms.error.JobSeekerError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobExceptionHandler {

    @ExceptionHandler(JobSeekerNotValidException.class)
    public ResponseEntity<JobSeekerNotValidException> jobSeekerNotValidExceptionHandler(JobSeekerNotValidException exc){

        JobSeekerError jobSeekerError = new JobSeekerError();
        jobSeekerError.setStatus(HttpStatus.BAD_REQUEST.value());
        jobSeekerError.setMessage(exc.getMessage());
        jobSeekerError.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(exc, HttpStatus.BAD_REQUEST);
    }
}
