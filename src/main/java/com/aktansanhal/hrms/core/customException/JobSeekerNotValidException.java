package com.aktansanhal.hrms.core.customException;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.lang.reflect.Executable;

public class JobSeekerNotValidException extends IllegalStateException {

    public JobSeekerNotValidException(String s) {
        super(s);
    }

    public JobSeekerNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobSeekerNotValidException(Throwable cause) {
        super(cause);
    }
}
