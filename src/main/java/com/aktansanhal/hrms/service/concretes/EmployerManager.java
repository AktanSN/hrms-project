package com.aktansanhal.hrms.service.concretes;

import com.aktansanhal.hrms.dao.abstracts.EmployerDao;
import com.aktansanhal.hrms.service.abstracts.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerManager implements EmployerService {


    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }
}
