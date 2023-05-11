package com.aktansanhal.hrms.dto.abstracts;


import com.aktansanhal.hrms.dto.concretes.JobPositionRequestDTO;
import com.aktansanhal.hrms.dto.concretes.JobPositionResponseDTO;
import com.aktansanhal.hrms.dto.concretes.JobSeekerRequestDTO;
import com.aktansanhal.hrms.dto.concretes.JobSeekerResponseDTO;
import com.aktansanhal.hrms.entity.concretes.JobPosition;
import com.aktansanhal.hrms.entity.concretes.JobSeeker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobPositionMapper {

    JobPosition jobPositionResponseToJobPosition(JobPositionResponseDTO jobPositionResponseDTO);
    JobPositionResponseDTO jobPositionToJobPositionResponse(JobPosition jobPosition);

    JobPosition jobPositionRequestToJobPosition(JobPositionRequestDTO jobSeekerRequestDTO);
    JobPositionRequestDTO jobSeekerToJobPositionRequest(JobPosition jobPosition);
}
