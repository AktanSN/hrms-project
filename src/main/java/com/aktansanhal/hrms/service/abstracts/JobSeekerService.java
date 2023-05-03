package com.aktansanhal.hrms.service.abstracts;

import com.aktansanhal.hrms.entity.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    JobSeeker createJobSeeker(JobSeeker jobSeeker);
    List<JobSeeker> getAllJobSeekers();
}
