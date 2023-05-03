package com.aktansanhal.hrms.service.concretes;

import com.aktansanhal.hrms.dao.abstracts.JobPositionDao;
import com.aktansanhal.hrms.service.abstracts.JobPositionService;
import org.springframework.stereotype.Service;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }
}
