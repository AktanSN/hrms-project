package com.aktansanhal.hrms.rest;



import com.aktansanhal.hrms.core.utilities.error.*;
import com.aktansanhal.hrms.dto.concretes.JobSeekerRequestDTO;
import com.aktansanhal.hrms.dto.concretes.JobSeekerResponseDTO;
import com.aktansanhal.hrms.service.abstracts.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public DataResult<List<JobSeekerResponseDTO>> getAllJobSeekers(){

        return new SuccessDataResult<List<JobSeekerResponseDTO>>("Listeleme Başarılı",jobSeekerService.getAllJobSeekers());
    }

    @GetMapping("/{jobSeekerId}")
    public DataResult<JobSeekerResponseDTO> getJobSeekerById(@PathVariable Long jobSeekerId){
        JobSeekerResponseDTO jobSeeker = jobSeekerService.getJobSeekerById(jobSeekerId);
        if(jobSeeker == null){
            return new ErrorDataResult<JobSeekerResponseDTO>("JobSeeker Bulunamadı");
        }

        return new SuccessDataResult<JobSeekerResponseDTO>("Listeleme Başarılı", jobSeekerService.getJobSeekerById(jobSeekerId));
    }

    @GetMapping("/page")
    public DataResult<List<JobSeekerResponseDTO>> getAllJobSeekersByPage(int pageNumber,int pageSize){
        return new SuccessDataResult<List<JobSeekerResponseDTO>>("Listeleme başarılı", jobSeekerService.getAllWithPage(pageNumber-1,pageSize));
    }

    @GetMapping("/search-by-name/startsWith")
    public DataResult<List<JobSeekerResponseDTO>> getByJobSeekerNameStartsWith(@RequestParam String jobSeekerName){
        return new SuccessDataResult<List<JobSeekerResponseDTO>>("Listeleme başarılı", jobSeekerService.getByFirstNameStartsWith(jobSeekerName));
    }

    @GetMapping("/search-by-name/contains")
    public DataResult<List<JobSeekerResponseDTO>> getByFirstNameOrLastNameContaining(@RequestParam String jobSeekerFirstName,@RequestParam String jobSeekerLastName){
        return new SuccessDataResult<List<JobSeekerResponseDTO>>("Listeleme başarılı", jobSeekerService.getByFirstNameOrLastNameContaining(jobSeekerFirstName,jobSeekerLastName));
    }



    @PostMapping
    public DataResult<JobSeekerResponseDTO> createJobSeeker(@RequestBody JobSeekerRequestDTO jobSeekerRequestDTO){

        JobSeekerResponseDTO value = jobSeekerService.createJobSeeker(jobSeekerRequestDTO);
        if(value != null){
            return new SuccessDataResult<JobSeekerResponseDTO>("Kayıt işlemi başarılı", value);
        }
        return new ErrorDataResult<JobSeekerResponseDTO>("İşlem başarısız");
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
    public DataResult<JobSeekerResponseDTO> updateJobSeekerById(@PathVariable Long jobSeekerId, @RequestBody JobSeekerRequestDTO jobSeekerRequestDTO){
        JobSeekerResponseDTO value = jobSeekerService.updateJobSeekerById(jobSeekerId, jobSeekerRequestDTO);
        if(value != null){
            return new SuccessDataResult<JobSeekerResponseDTO>("Güncelleme başarılı", value );
        }
        return new ErrorDataResult<JobSeekerResponseDTO>("Güncelleme işlemi başarısız");
    }
}
