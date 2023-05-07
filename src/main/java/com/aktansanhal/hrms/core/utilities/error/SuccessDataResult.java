package com.aktansanhal.hrms.core.utilities.error;

public class SuccessDataResult<T>  extends DataResult<T>{
    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }


}
