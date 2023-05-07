package com.aktansanhal.hrms.core.utilities.error;

public class ErrorResult extends Result{
    public ErrorResult(String message) {
        super(false, message);
    }

}
