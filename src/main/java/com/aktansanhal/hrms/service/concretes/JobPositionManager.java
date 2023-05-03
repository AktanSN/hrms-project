package com.aktansanhal.hrms.service.concretes;

import com.aktansanhal.hrms.dao.abstracts.JobPositionDao;
import com.aktansanhal.hrms.entity.concretes.JobPosition;
import com.aktansanhal.hrms.service.abstracts.JobPositionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }


    @Override
    public List<JobPosition> getAllJobPositions() {
        return jobPositionDao.findAll();
    }

    @Override
    public JobPosition getJobPositionById(Long jobPositionId) {

        List<JobPosition> jobPositions = getAllJobPositions();

        Optional<JobPosition> jobPosition = jobPositions.stream().filter(position -> position.getId() == jobPositionId).findFirst();
        if(jobPosition.isEmpty()){
            return null;
        }

        return jobPosition.get();
    }



    @Override
    public JobPosition createJobPosition(JobPosition jobPosition) {
        return jobPositionDao.save(jobPosition);
    }

    @Override
    public Long deleteJobPositionById(Long jobPositionId) {
        JobPosition jobPosition = getJobPositionById(jobPositionId);

        if(jobPosition != null){
            jobPositionDao.deleteById(jobPositionId);
        }

        return jobPositionId;
    }

    @Override
    public JobPosition updateJobPositionById(Long jobPositionId, JobPosition jobPosition) {
        JobPosition checkJobPosition = getJobPositionById(jobPositionId);
        if(checkJobPosition != null){
            jobPositionDao.deleteById(jobPositionId);
            return createJobPosition(jobPosition);
        }
        return null;
    }
}
