package com.aktansanhal.hrms.service.abstracts;

import com.aktansanhal.hrms.entity.concretes.JobSeeker;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobSeekerService {
    JobSeeker getJobSeekerById(Long jobSeekerId);
    List<JobSeeker> getAllJobSeekers();

    JobSeeker createJobSeeker(JobSeeker jobSeeker);

    Long deleteJobSeekerById(Long jobSeekerId);

    JobSeeker updateJobSeekerById(Long jobSeekerId, JobSeeker jobSeeker);

    List<JobSeeker> getAllWithPage(int paneNumber,int pageSize);
}
