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
@RequestMapping("/employer-api/employers")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }



    @GetMapping
    public DataResult<List<Employer>> getAllEmployers(){

        return new SuccessDataResult<List<Employer>>("Listeleme Başarılı", employerService.getAllEmployers());
    }

    @GetMapping("/{employerId}")
    public DataResult<Employer> getEmployerById(@PathVariable Long employerId){
        Employer employer = employerService.getEmployerById(employerId);

        if(employer == null){
            return new ErrorDataResult<Employer>("Employer bulunamadı", null);
        }

        return new SuccessDataResult<Employer>("İşlem başarılı",employer );
    }

    @GetMapping("/search-by-name/startsWith")
    public DataResult<List<Employer>> getByCompanyNameStartsWith(@RequestParam String companyName) {
        return new SuccessDataResult<List<Employer>>("Listeleme başarılı", employerService.getByCompanyNameStartsWith(companyName));
    }

    @GetMapping("/search-by-name/contains")
    public DataResult<List<Employer>> getByCompanyNameContains(@RequestParam String companyName) {
        return new SuccessDataResult<List<Employer>>("Listeleme başarılı", employerService.getByCompanyNameContains(companyName));
    }

    @GetMapping("/order-by-name")
    public DataResult<List<Employer>> getAllByOrderByCompanyNameAsc() {
        return new SuccessDataResult<List<Employer>>("Listeleme başarılı", employerService.getAllByOrderByCompanyNameAsc());
    }

    @PostMapping
    public DataResult<Employer> createEmployer(@RequestBody Employer employer){
        Employer isSuccess = employerService.createEmployer(employer);
        if(isSuccess == null){
            return new ErrorDataResult<Employer>("Kayıt oluşturulamadı", null);
        }
        return new SuccessDataResult<Employer>("Kayıt başarılı",isSuccess);
    }

    @DeleteMapping("/{employerId}")
    public Result deleteEmployerById(@PathVariable Long employerId){

        Long isSuccess = employerService.deleteEmloyerById(employerId);
        if(isSuccess == null){
            return new ErrorResult("İşlem başarısız");
        }
        return new SuccessResult("Silme işlemi başarılı");

    }

    @PutMapping("/{employerId}")
    public DataResult<Employer> updateEmployerById(@PathVariable Long employerId,@RequestBody Employer employer){
        Employer isSuccess = employerService.updateEmployerById(employerId,employer);
        if(isSuccess == null){
            return new ErrorDataResult<Employer>("İşlem başarısız",null);
        }
        return new SuccessDataResult<Employer>("Güncelleme işlemi başarılı", isSuccess);
    }
}
