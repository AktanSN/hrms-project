package com.aktansanhal.hrms.service.abstracts;

import com.aktansanhal.hrms.core.utilities.error.DataResult;
import com.aktansanhal.hrms.core.utilities.error.Result;
import com.aktansanhal.hrms.entity.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();
    DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement);

    DataResult<List<JobAdvertisement>> getAllByStatusTrueOrderByStartDateAsc();

}
