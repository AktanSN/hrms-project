package com.aktansanhal.hrms.service.concretes;

import org.springframework.stereotype.Service;

@Service
public class CompanyEmailService {

    public static boolean checkEmail(String email) {
        return email.endsWith("@id3.com.tr");
    }
}
