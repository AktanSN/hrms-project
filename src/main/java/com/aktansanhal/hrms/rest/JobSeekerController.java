package com.aktansanhal.hrms.rest;



import com.aktansanhal.hrms.core.utilities.error.*;
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
    public DataResult<List<JobSeeker>> getAllJobSeekers(){

        return new SuccessDataResult<List<JobSeeker>>("Listeleme Başarılı",jobSeekerService.getAllJobSeekers());
    }

    @GetMapping("/JobSeekers/{jobSeekerId}")
    public DataResult<JobSeeker> getJobSeekerById(@PathVariable Long jobSeekerId){
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerById(jobSeekerId);
        if(jobSeeker == null){
            return new ErrorDataResult<JobSeeker>("JobSeeker Bulunamadı");
        }

        return new SuccessDataResult<JobSeeker>("Listeleme Başarılı", jobSeekerService.getJobSeekerById(jobSeekerId));
    }

    @PostMapping("/JobSeekers")
    public DataResult<JobSeeker> createJobSeeker(@RequestBody JobSeeker jobSeeker){

        JobSeeker value = jobSeekerService.createJobSeeker(jobSeeker);
        if(value != null){
            return new SuccessDataResult<JobSeeker>("İşlem başarılı", value);
        }
        return new ErrorDataResult<JobSeeker>("İşlem başarısız");
    }

    @DeleteMapping("/JobSeekers/{jobSeekerId}")
    public Result deleteJobSeeerById(@PathVariable Long jobSeekerId){
        Long value = jobSeekerService.deleteJobSeekerById(jobSeekerId);
        if(value == null){
            return new ErrorResult("Silme işlemi başarısız");
        }

        return new SuccessResult("Silme işlemi başarılı");
    }

    @PutMapping("/JobSeekers/{jobSeekerId}")
    public DataResult<JobSeeker> updateJobSeekerById(@PathVariable Long jobSeekerId, @RequestBody JobSeeker jobSeeker){
        JobSeeker value = jobSeekerService.updateJobSeekerById(jobSeekerId, jobSeeker);
        if(value != null){
            return new SuccessDataResult<JobSeeker>("Güncelleme başarılı", value );
        }
        return new ErrorDataResult<JobSeeker>("Güncelleme işlemi başarısız");
    }
}
