package com.aktansanhal.hrms.rest;

import com.aktansanhal.hrms.entity.concretes.Employer;
import com.aktansanhal.hrms.entity.concretes.JobPosition;
import com.aktansanhal.hrms.service.abstracts.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/JobPosition-Api")
public class JobPositionController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }


    @GetMapping("/JobPositions")
    public List<JobPosition> getAllJobPositions(){
        return jobPositionService.getAllJobPositions();
    }

    @GetMapping("/JobPositions/{jobPositionId}")
    public JobPosition getJobPositionById(@PathVariable Long jobPositionId){
        JobPosition jobPosition = jobPositionService.getJobPositionById(jobPositionId);
        if(jobPosition == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return jobPosition;
    }

    @PostMapping("/JobPositions")
    public ResponseEntity<Object> createJobPosition(@RequestBody JobPosition jobPosition){

        jobPositionService.createJobPosition(jobPosition);

        return ResponseEntity.created(null).build();

    }

    @DeleteMapping("/JobPositions/{jobPositionId}")
    public ResponseEntity<Object> deleteJobPositionById(@PathVariable Long jobPositionId){

        jobPositionService.deleteJobPositionById(jobPositionId);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/JobPositions/{jobPositionId}")
    public JobPosition updateJobPositionById(@PathVariable Long jobPositionId, @RequestBody JobPosition jobPosition){

        return jobPositionService.updateJobPositionById(jobPositionId,jobPosition);
    }
}
