package com.aktansanhal.hrms.rest;


import com.aktansanhal.hrms.core.utilities.error.DataResult;
import com.aktansanhal.hrms.core.utilities.error.SuccessDataResult;
import com.aktansanhal.hrms.entity.concretes.JobAdvertisement;
import com.aktansanhal.hrms.service.abstracts.JobAdvertisementService;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

    private JobAdvertisementService jobAdvertisementService;

    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping
    public DataResult<List<JobAdvertisement>> getAll(){
        return jobAdvertisementService.getAll();
    }

    @GetMapping("/getAllByOrderByStartDateAsc")
    public DataResult<List<JobAdvertisement>> getAllByStatusTrueOrderByStartDateAsc(){
        return jobAdvertisementService.getAllByStatusTrueOrderByStartDateAsc();
    }

    @GetMapping("/geAllByStatusTrue")
    public DataResult<List<JobAdvertisement>> getAllByStatusTrue(){
        return jobAdvertisementService.getAllByStatusTrue();
    }

    @GetMapping("/getByCompanyName")
    public DataResult<List<JobAdvertisement>> getJobAdvertisementsByCompanyName(@RequestParam String companyName){
        return jobAdvertisementService.getJobAdvertisementsByEmployer_CompanyName(companyName);
    }



    @PostMapping
    public DataResult<JobAdvertisement> createJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.add(jobAdvertisement);
    }


}
