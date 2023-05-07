package com.aktansanhal.hrms.rest;

import com.aktansanhal.hrms.core.utilities.error.*;
import com.aktansanhal.hrms.entity.concretes.Employer;
import com.aktansanhal.hrms.service.abstracts.EmployerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/Employer-Api")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }



    @GetMapping("/Employers")
    public DataResult<List<Employer>> getAllEmployers(){

        return new SuccessDataResult<List<Employer>>("Listeleme Başarılı", employerService.getAllEmployers());
    }

    @GetMapping("/Employers/{employerId}")
    public DataResult<Employer> getEmployerById(@PathVariable Long employerId){
        Employer employer = employerService.getEmployerById(employerId);

        if(employer == null){
            return new ErrorDataResult<Employer>("Employer bulunamadı", null);
        }

        return new SuccessDataResult<Employer>("İşlem başarılı",employer );
    }

    @PostMapping("/Employers")
    public DataResult<Employer> createEmployer(@RequestBody Employer employer){
        Employer isSuccess = employerService.createEmployer(employer);
        if(isSuccess == null){
            return new ErrorDataResult<Employer>("Kayıt oluşturulamadı", null);
        }
        return new SuccessDataResult<Employer>("Kayıt başarılı",isSuccess);
    }

    @DeleteMapping("/Employers/{employerId}")
    public Result deleteEmployerById(@PathVariable Long employerId){

        Long isSuccess = employerService.deleteEmloyerById(employerId);
        if(isSuccess == null){
            return new ErrorResult("İşlem başarısız");
        }
        return new SuccessResult("Silme işlemi başarılı");

    }

    @PutMapping("/Employers/{employerId}")
    public DataResult<Employer> updateEmployerById(@PathVariable Long employerId,@RequestBody Employer employer){
        Employer isSuccess = employerService.updateEmployerById(employerId,employer);
        if(isSuccess == null){
            return new ErrorDataResult<Employer>("İşlem başarısız",null);
        }
        return new SuccessDataResult<Employer>("Güncelleme işlemi başarılı", isSuccess);
    }
}
