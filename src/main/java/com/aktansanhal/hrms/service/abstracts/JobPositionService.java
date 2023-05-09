package com.aktansanhal.hrms.service.abstracts;

import com.aktansanhal.hrms.entity.concretes.JobPosition;
import com.aktansanhal.hrms.entity.concretes.JobSeeker;

import java.util.List;

public interface JobPositionService {

    JobPosition getJobPositionById(Long jobPositionId);
    List<JobPosition> getAllJobPositions();

    JobPosition createJobPosition(JobPosition jobPosition);

    Long deleteJobPositionById(Long jobPositionId);

    JobPosition updateJobPositionById(Long jobPositionId, JobPosition jobPosition);

    List<JobPosition> getByPositionNameStartingWith(String positionName);

    List<JobPosition> getByPositionNameContains(String positionName);

    List<JobPosition> getAllByOrderByPositionNameAsc();
}
