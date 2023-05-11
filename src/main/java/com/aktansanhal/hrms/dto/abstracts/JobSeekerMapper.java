package com.aktansanhal.hrms.dto.abstracts;


import com.aktansanhal.hrms.dto.concretes.JobPositionResponseDTO;
import com.aktansanhal.hrms.dto.concretes.JobSeekerRequestDTO;
import com.aktansanhal.hrms.dto.concretes.JobSeekerResponseDTO;
import com.aktansanhal.hrms.entity.concretes.JobSeeker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobSeekerMapper {


    JobSeeker jobSeekerResponseToJobSeeker(JobSeekerResponseDTO jobSeekerResponseDTO);
    JobSeekerResponseDTO jobSeekerToJobSeekerResponse(JobSeeker jobSeeker);

    JobSeeker jobSeekerRequestToJobSeeker(JobSeekerRequestDTO jobSeekerRequestDTO);
    JobSeekerRequestDTO jobSeekerToJobSeekerRequest(JobSeeker jobSeeker);
}
