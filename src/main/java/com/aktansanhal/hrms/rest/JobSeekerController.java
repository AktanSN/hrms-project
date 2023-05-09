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
@RequestMapping("/jobSeeker-api/jobSeekers")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    @Autowired // alternatifleri
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }



    @GetMapping
    public DataResult<List<JobSeeker>> getAllJobSeekers(){

        return new SuccessDataResult<List<JobSeeker>>("Listeleme Başarılı",jobSeekerService.getAllJobSeekers());
    }

    @GetMapping("/{jobSeekerId}")
    public DataResult<JobSeeker> getJobSeekerById(@PathVariable Long jobSeekerId){
        JobSeeker jobSeeker = jobSeekerService.getJobSeekerById(jobSeekerId);
        if(jobSeeker == null){
            return new ErrorDataResult<JobSeeker>("JobSeeker Bulunamadı");
        }

        return new SuccessDataResult<JobSeeker>("Listeleme Başarılı", jobSeekerService.getJobSeekerById(jobSeekerId));
    }

    @GetMapping("/page")
    public DataResult<List<JobSeeker>> getAllJobSeekersByPage(int pageNumber,int pageSize){
        return new SuccessDataResult<List<JobSeeker>>("Listeleme başarılı", jobSeekerService.getAllWithPage(pageNumber-1,pageSize));
    }

    @GetMapping("/search-by-name/startsWith")
    public DataResult<List<JobSeeker>> getByJobSeekerNameStartsWith(@RequestParam String jobSeekerName){
        return new SuccessDataResult<List<JobSeeker>>("Listeleme başarılı", jobSeekerService.getByFirstNameStartsWith(jobSeekerName));
    }

    @GetMapping("/search-by-name/contains")
    public DataResult<List<JobSeeker>> getByFirstNameOrLastNameContaining(@RequestParam String jobSeekerFirstName,@RequestParam String jobSeekerLastName){
        return new SuccessDataResult<List<JobSeeker>>("Listeleme başarılı", jobSeekerService.getByFirstNameOrLastNameContaining(jobSeekerFirstName,jobSeekerLastName));
    }



    @PostMapping
    public DataResult<JobSeeker> createJobSeeker(@RequestBody JobSeeker jobSeeker){

        JobSeeker value = jobSeekerService.createJobSeeker(jobSeeker);
        if(value != null){
            return new SuccessDataResult<JobSeeker>("Kayıt işlemi başarılı", value);
        }
        return new ErrorDataResult<JobSeeker>("İşlem başarısız");
    }

    @DeleteMapping("/{jobSeekerId}")
    public Result deleteJobSeeerById(@PathVariable Long jobSeekerId){
        Long value = jobSeekerService.deleteJobSeekerById(jobSeekerId);
        if(value == null){
            return new ErrorResult("Silme işlemi başarısız");
        }

        return new SuccessResult("Silme işlemi başarılı");
    }

    @PutMapping("/{jobSeekerId}")
    public DataResult<JobSeeker> updateJobSeekerById(@PathVariable Long jobSeekerId, @RequestBody JobSeeker jobSeeker){
        JobSeeker value = jobSeekerService.updateJobSeekerById(jobSeekerId, jobSeeker);
        if(value != null){
            return new SuccessDataResult<JobSeeker>("Güncelleme başarılı", value );
        }
        return new ErrorDataResult<JobSeeker>("Güncelleme işlemi başarısız");
    }
}
