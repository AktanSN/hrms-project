package com.aktansanhal.hrms.service.concretes;

import com.aktansanhal.hrms.dao.abstracts.EmployerDao;
import com.aktansanhal.hrms.entity.concretes.Employer;
import com.aktansanhal.hrms.service.abstracts.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerManager implements EmployerService {


    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public Employer getEmployerById(Long employerId) {

        List<Employer> employers = getAllEmployers();

        Optional<Employer> employer = employers.stream().filter(employr -> employr.getId() == employerId).findFirst();
        if(employer.isEmpty()){
            return null;
        }
        return employer.get();
    }

    @Override
    public List<Employer> getAllEmployers() {
        return employerDao.findAll();
    }

    @Override
    public Employer createEmployer(Employer employer) {
        return employerDao.save(employer);
    }

    @Override
    public Long deleteEmloyerById(Long employerId) {

        Employer employer = getEmployerById(employerId);

        if(employer != null){
            employerDao.deleteById(employerId);
        }

        return employerId;
    }

    @Override
    public Employer updateEmployerById(Long employerId, Employer employer) {
        Employer checkEmployer = getEmployerById(employerId);

        if(checkEmployer != null){
            employerDao.deleteById(employerId);
            return createEmployer(employer);
        }
        return null;
    }
}
