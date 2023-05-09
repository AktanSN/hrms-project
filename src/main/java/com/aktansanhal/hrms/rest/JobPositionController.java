package com.aktansanhal.hrms.rest;

import com.aktansanhal.hrms.core.utilities.error.*;
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
@RequestMapping("/jobPosition-api/jobPositions")
public class JobPositionController {

    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }


    @GetMapping
    public DataResult<List<JobPosition>> getAllJobPositions(){
        return new SuccessDataResult<List<JobPosition>>("Listeleme başarılı",jobPositionService.getAllJobPositions());
    }

    @GetMapping("/{jobPositionId}")
    public DataResult<JobPosition> getJobPositionById(@PathVariable Long jobPositionId){
        JobPosition jobPosition = jobPositionService.getJobPositionById(jobPositionId);
        if(jobPosition == null){
            return new ErrorDataResult<JobPosition>("JobPosition bulunamadı",null);
        }

        return new SuccessDataResult<JobPosition>("İşlem Başarılı", jobPosition);
    }

    @GetMapping("/search-by-name/startsWith")
    public DataResult<List<JobPosition>> getByPositionNameStartingWith(@RequestParam String positionName){
        return new SuccessDataResult<List<JobPosition>>("Listeleme başarılı", jobPositionService.getByPositionNameStartingWith(positionName));
    }

    @GetMapping("/search-by-name/contains")
    public DataResult<List<JobPosition>> getByPositionNameContains(@RequestParam String positionName) {
        return new SuccessDataResult<List<JobPosition>>("Listeleme başarılı", jobPositionService.getByPositionNameContains(positionName));
    }

    @GetMapping("/order-by-name")
    public DataResult<List<JobPosition>>  getAllByOrderByPositionNameAsc() {
        return new SuccessDataResult<List<JobPosition>>("Listeleme başarılı", jobPositionService.getAllByOrderByPositionNameAsc());
    }

    @PostMapping
    public DataResult<JobPosition> createJobPosition(@RequestBody JobPosition jobPosition){

        JobPosition isSuccess = jobPositionService.createJobPosition(jobPosition);
        if(isSuccess == null){
            return new ErrorDataResult<JobPosition>("Kayıt oluşturulamadı", null);
        }

        return new SuccessDataResult<JobPosition>("Kayıt başarılı", isSuccess);

    }

    @DeleteMapping("/{jobPositionId}")
    public Result deleteJobPositionById(@PathVariable Long jobPositionId){

        Long isSuccess = jobPositionService.deleteJobPositionById(jobPositionId);
        if(isSuccess == null){
            return new ErrorResult("İşlem başarısız");
        }
        return new SuccessResult("Silme işlemi başarılı");

    }

    @PutMapping("/{jobPositionId}")
    public DataResult<JobPosition> updateJobPositionById(@PathVariable Long jobPositionId, @RequestBody JobPosition jobPosition){

        JobPosition isSuccess = jobPositionService.updateJobPositionById(jobPositionId,jobPosition);
        if(isSuccess == null){
            return new ErrorDataResult<JobPosition>("İşlem başarısız", null);
        }
        return new SuccessDataResult<JobPosition>("Güncelleme işlemi başarılı", isSuccess);
    }
}
