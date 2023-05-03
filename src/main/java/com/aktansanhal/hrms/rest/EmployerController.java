package com.aktansanhal.hrms.rest;

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
    public List<Employer> getAllEmployers(){
        return employerService.getAllEmployers();
    }

    @GetMapping("/Employers/{employerId}")
    public Employer getEmployerById(@PathVariable Long employerId){
        Employer employer = employerService.getEmployerById(employerId);

        if(employer == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return employer;
    }

    @PostMapping("/Employers")
    public ResponseEntity<Object> createEmployer(@RequestBody Employer employer){
        employerService.createEmployer(employer);

        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/Employers/{employerId}")
    public ResponseEntity<Object> deleteEmployerById(@PathVariable Long employerId){

        employerService.deleteEmloyerById(employerId);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/Employers/{employerId}")
    public Employer updateEmployerById(@PathVariable Long employerId,@RequestBody Employer employer){
        return employerService.updateEmployerById(employerId,employer);
    }
}
