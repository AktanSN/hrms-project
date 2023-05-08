package com.aktansanhal.hrms.service.concretes;

import org.springframework.stereotype.Service;

@Service
public class GeneralEmailService {


    public static boolean checkEmail(String email) {
        return email.endsWith("@gmail.com");
    }

}
