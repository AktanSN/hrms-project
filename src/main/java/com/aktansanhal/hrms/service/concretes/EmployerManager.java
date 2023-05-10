package com.aktansanhal.hrms.service.concretes;

import com.aktansanhal.hrms.dao.abstracts.EmployerDao;
import com.aktansanhal.hrms.dao.abstracts.JobPositionDao;
import com.aktansanhal.hrms.entity.concretes.Employer;
import com.aktansanhal.hrms.entity.concretes.JobPosition;
import com.aktansanhal.hrms.service.abstracts.EmployerService;
import com.aktansanhal.hrms.service.abstracts.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerManager implements EmployerService {


    private EmployerDao employerDao;

    @Autowired
    private JobPositionService jobPositionService;

    private JobPositionDao jobPositionDao;


    @Autowired
    public EmployerManager(EmployerDao employerDao,
                           JobPositionDao jobPositionDao) {
        this.employerDao = employerDao;
        this.jobPositionDao = jobPositionDao;
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

        Optional<Employer> isEmailExist = getAllEmployers().stream().filter( emp -> emp.getEmail().equals(employer.getEmail())).findFirst();

        if(!isEmailExist.isPresent() && CompanyEmailService.checkEmail(employer.getEmail())){
            //jobPositionService.createJobPosition(employer.getJobPosition().get(0));
            return employerDao.save(employer);
        }
        return null;
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

    @Override
    public List<Employer> getByCompanyNameStartsWith(String companyName) {
        return employerDao.getByCompanyNameStartsWith(companyName);
    }

    @Override
    public List<Employer> getByCompanyNameContains(String companyName) {
        return employerDao.getByCompanyNameContains(companyName);
    }

    @Override
    public List<Employer> getAllByOrderByCompanyNameAsc() {
        return employerDao.getAllByOrderByCompanyNameAsc();
    }
}
