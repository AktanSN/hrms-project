package com.aktansanhal.hrms.service.abstracts;

import com.aktansanhal.hrms.entity.concretes.Employer;
import com.aktansanhal.hrms.entity.concretes.JobPosition;

import java.util.List;

public interface EmployerService {

    Employer getEmployerById(Long employerId);
    List<Employer> getAllEmployers();

    Employer createEmployer(Employer employer);

    Long deleteEmloyerById(Long employerId);

    Employer updateEmployerById(Long employerId, Employer employer);
}
