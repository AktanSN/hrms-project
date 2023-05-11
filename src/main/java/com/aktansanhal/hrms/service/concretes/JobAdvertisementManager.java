package com.aktansanhal.hrms.service.concretes;

import com.aktansanhal.hrms.core.utilities.error.DataResult;
import com.aktansanhal.hrms.core.utilities.error.Result;
import com.aktansanhal.hrms.core.utilities.error.SuccessDataResult;
import com.aktansanhal.hrms.dao.abstracts.JobAdvertisementDAO;
import com.aktansanhal.hrms.entity.concretes.JobAdvertisement;
import com.aktansanhal.hrms.service.abstracts.JobAdvertisementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {


    private JobAdvertisementDAO jobAdvertisementDAO;

    public JobAdvertisementManager(JobAdvertisementDAO jobAdvertisementDAO) {
        this.jobAdvertisementDAO = jobAdvertisementDAO;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
       return new SuccessDataResult<List<JobAdvertisement>>("Listelendi",jobAdvertisementDAO.findAll() ) ;
    }

    @Override
    public DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement) {
        JobAdvertisement jobAdvertisement1 = jobAdvertisementDAO.save(jobAdvertisement);
        return new SuccessDataResult<JobAdvertisement>("Başarılı", jobAdvertisement1);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByStatusTrueOrderByStartDateAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>("Listelendi", jobAdvertisementDAO.getAllByStatusTrueOrderByStartDateAsc());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByStatusTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>("Listelendi", jobAdvertisementDAO.getAllByStatusTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getJobAdvertisementsByEmployer_CompanyName(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>("Listelendi", jobAdvertisementDAO.getJobAdvertisementsByEmployer_CompanyName(companyName));
    }


}
