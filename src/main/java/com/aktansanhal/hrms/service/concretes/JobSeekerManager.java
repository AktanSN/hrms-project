package com.aktansanhal.hrms.service.concretes;


import com.aktansanhal.hrms.dao.abstracts.JobSeekerDao;
import com.aktansanhal.hrms.entity.concretes.JobSeeker;
import com.aktansanhal.hrms.service.abstracts.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerDao.save(jobSeeker);
    }

    @Override
    public List<JobSeeker> getAllJobSeekers() {
        return this.jobSeekerDao.findAll();
    }
}
