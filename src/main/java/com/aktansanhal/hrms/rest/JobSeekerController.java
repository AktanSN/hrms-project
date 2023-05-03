package com.aktansanhal.hrms.rest;


import com.aktansanhal.hrms.core.customException.JobSeekerNotValidException;
import com.aktansanhal.hrms.entity.concretes.JobSeeker;
import com.aktansanhal.hrms.service.abstracts.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/JobSeeker-Api")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    @Autowired // alternatifleri
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }



    @GetMapping("/JobSeekers")
    public List<JobSeeker> getAllJobSeekers(){
        return jobSeekerService.getAllJobSeekers();
    }

    @GetMapping("/JobSeekers/{jobSeekerId}")
    public JobSeeker getJobSeekerById(@PathVariable Long jobSeekerId){
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerById(jobSeekerId);
        if(jobSeeker == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return jobSeeker;
    }

    @PostMapping("/JobSeekers")
    public ResponseEntity<Object> createJobSeeker(@RequestBody JobSeeker jobSeeker){

        jobSeekerService.createJobSeeker(jobSeeker);

        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/JobSeekers/{jobSeekerId}")
    public ResponseEntity<Object> deleteJobSeeerById(@PathVariable Long jobSeekerId){
        jobSeekerService.deleteJobSeekerById(jobSeekerId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/JobSeekers/{jobSeekerId}")
    public JobSeeker updateJobSeekerById(@PathVariable Long jobSeekerId, @RequestBody JobSeeker jobSeeker){

        return jobSeekerService.updateJobSeekerById(jobSeekerId, jobSeeker);
    }
}
