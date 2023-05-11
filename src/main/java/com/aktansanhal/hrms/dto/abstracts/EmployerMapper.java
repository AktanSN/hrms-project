package com.aktansanhal.hrms.dto.abstracts;


import com.aktansanhal.hrms.dto.concretes.EmployerRequestDTO;
import com.aktansanhal.hrms.dto.concretes.EmployerResponseDTO;
import com.aktansanhal.hrms.dto.concretes.JobPositionRequestDTO;
import com.aktansanhal.hrms.dto.concretes.JobPositionResponseDTO;
import com.aktansanhal.hrms.entity.concretes.Employer;
import com.aktansanhal.hrms.entity.concretes.JobPosition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployerMapper {


    Employer employerResponseToEmployer(EmployerResponseDTO employerResponseDTO);
    EmployerResponseDTO employerToEmployerResponse(Employer employer);

    Employer employerRequestToEmployer(EmployerRequestDTO employerRequestDTO);
    EmployerRequestDTO employerToEmployerRequest(Employer employer);
}
