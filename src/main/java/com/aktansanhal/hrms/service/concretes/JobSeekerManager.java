package com.aktansanhal.hrms.service.concretes;


import com.aktansanhal.hrms.dao.abstracts.JobSeekerDao;
import com.aktansanhal.hrms.entity.concretes.JobSeeker;
import com.aktansanhal.hrms.service.abstracts.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        this.jobSeekerDao = jobSeekerDao;
    }



    @Override
    public List<JobSeeker> getAllJobSeekers() {
        return this.jobSeekerDao.findAll();
    }

    @Override
    public JobSeeker createJobSeeker(JobSeeker jobSeeker) {
        return jobSeekerDao.save(jobSeeker);
    }



    @Override
    public JobSeeker getJobSeekerById(Long jobSeekerId) {

        List<JobSeeker> jobSeekers = getAllJobSeekers();

        Optional<JobSeeker> optionalJobSeeker = jobSeekers.stream().filter(jobSeeker -> jobSeeker.getId() == jobSeekerId).findFirst();

        if(optionalJobSeeker.isEmpty()){
            return null;
        }
        return optionalJobSeeker.get();
    }

    @Override
    public Long deleteJobSeekerById(Long jobSeekerId) {

        JobSeeker jobSeeker = getJobSeekerById(jobSeekerId);
        if(jobSeeker != null){
            jobSeekerDao.deleteById(jobSeekerId);
        }

        return jobSeekerId;
    }

    @Override
    public JobSeeker updateJobSeekerById(Long jobSeekerId, JobSeeker jobSeeker) {
        JobSeeker jobSeekerCheck = getJobSeekerById(jobSeekerId);
        if(jobSeekerCheck != null){
           jobSeekerDao.deleteById(jobSeekerId);
           return createJobSeeker(jobSeeker);
        }
        return null;
    }

}
