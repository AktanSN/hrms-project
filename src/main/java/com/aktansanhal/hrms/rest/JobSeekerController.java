package com.aktansanhal.hrms.rest;


import com.aktansanhal.hrms.core.customException.JobSeekerNotValidException;
import com.aktansanhal.hrms.entity.concretes.JobSeeker;
import com.aktansanhal.hrms.service.abstracts.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobseeker-api")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }



    @PostMapping("/jobseekers")
    public JobSeeker createJobSeeker(@RequestBody JobSeeker jobSeeker){

        if (jobSeeker.getFirstName() == null || jobSeeker.getLastName() == null || jobSeeker.getNationalNumber() == null || jobSeeker.getBirthYear()== null || jobSeeker.getEmail() == null || jobSeeker.getPassword() == null) {
            throw new JobSeekerNotValidException("JobSeeker is not valid!");
        }

        return this.jobSeekerService.createJobSeeker(jobSeeker);

    }

    @GetMapping("/jobseekers")
    public List<JobSeeker> getAllJobSeekers(){
        return this.jobSeekerService.getAllJobSeekers();
    }
}
