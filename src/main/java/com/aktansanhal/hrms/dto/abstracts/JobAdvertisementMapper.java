package com.aktansanhal.hrms.dto.abstracts;


import com.aktansanhal.hrms.dto.concretes.JobAdvertisementRequestDTO;
import com.aktansanhal.hrms.dto.concretes.JobAdvertisementResponseDTO;
import com.aktansanhal.hrms.dto.concretes.JobPositionRequestDTO;
import com.aktansanhal.hrms.dto.concretes.JobPositionResponseDTO;
import com.aktansanhal.hrms.entity.concretes.JobAdvertisement;
import com.aktansanhal.hrms.entity.concretes.JobPosition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobAdvertisementMapper {


    JobAdvertisement jobAdvertisementResponseToJobAdvertisement(JobAdvertisementResponseDTO jobAdvertisementResponseDTO);
    JobAdvertisementResponseDTO jobAdvertisementToJobAdvertisementResponse(JobAdvertisement jobAdvertisement);

    JobAdvertisement jobAdvertisementRequestToJobAdvertisement(JobAdvertisementRequestDTO jobAdvertisementRequestDTO);
    JobAdvertisementRequestDTO jobAdvertisementToJobAdvertisementRequest(JobAdvertisement jobAdvertisement);
}
