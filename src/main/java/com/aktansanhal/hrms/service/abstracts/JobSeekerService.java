package com.aktansanhal.hrms.service.abstracts;

import com.aktansanhal.hrms.dto.concretes.JobSeekerRequestDTO;
import com.aktansanhal.hrms.dto.concretes.JobSeekerResponseDTO;

import java.util.List;

public interface JobSeekerService {
    JobSeekerResponseDTO getJobSeekerById(Long jobSeekerId);
    List<JobSeekerResponseDTO> getAllJobSeekers();

    JobSeekerResponseDTO createJobSeeker(JobSeekerRequestDTO jobSeekerRequestDTO);

    Long deleteJobSeekerById(Long jobSeekerId);

    JobSeekerResponseDTO updateJobSeekerById(Long jobSeekerId, JobSeekerRequestDTO jobSeekerRequestDTO);

    List<JobSeekerResponseDTO> getAllWithPage(int paneNumber,int pageSize);

    List<JobSeekerResponseDTO> getByFirstNameStartsWith(String jobSeekerName);

    List<JobSeekerResponseDTO> getByFirstNameOrLastNameContaining(String jobSeekerFirstName,String jobSeekerLastName);
}
