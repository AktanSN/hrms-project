package com.aktansanhal.hrms.service.concretes;




import com.aktansanhal.hrms.dao.abstracts.JobSeekerDao;
import com.aktansanhal.hrms.dto.abstracts.JobSeekerMapper;
import com.aktansanhal.hrms.dto.concretes.JobSeekerRequestDTO;
import com.aktansanhal.hrms.dto.concretes.JobSeekerResponseDTO;
import com.aktansanhal.hrms.entity.concretes.JobSeeker;
import com.aktansanhal.hrms.mernis.RDTKPSPublicSoap;

import com.aktansanhal.hrms.service.abstracts.JobPositionService;
import com.aktansanhal.hrms.service.abstracts.JobSeekerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    private final JobSeekerMapper jobSeekerMapper;

    private JobPositionService jobPositionService;

    public JobSeekerManager(JobSeekerDao jobSeekerDao, JobSeekerMapper jobSeekerMapper, JobPositionService jobPositionService) {
        this.jobSeekerDao = jobSeekerDao;
        this.jobSeekerMapper = jobSeekerMapper;
        this.jobPositionService = jobPositionService;
    }

    @Override
    public List<JobSeekerResponseDTO> getAllJobSeekers() {
        return this.jobSeekerDao.findAll().stream().map(js -> jobSeekerMapper.jobSeekerToJobSeekerResponse(js)).collect(Collectors.toList());
    }

    @Override
    public JobSeekerResponseDTO createJobSeeker(JobSeekerRequestDTO jobSeekerRequestDTO) {
        RDTKPSPublicSoap pfqkpsPublicSoap = new RDTKPSPublicSoap();

        try {
            boolean isSuccess = pfqkpsPublicSoap.TCKimlikNoDogrula(jobSeekerRequestDTO.nationalNumber(),jobSeekerRequestDTO.firstName(),jobSeekerRequestDTO.lastName(),jobSeekerRequestDTO.birthYear());

            Optional<JobSeekerResponseDTO> isEmailExist = getAllJobSeekers().stream().filter(js -> js.email().equals(jobSeekerRequestDTO.email())).findFirst();
            Optional<JobSeekerResponseDTO> isTcExist = getAllJobSeekers().stream().filter( js -> js.nationalNumber().equals(jobSeekerRequestDTO.nationalNumber())).findFirst();
            if(isSuccess && !isEmailExist.isPresent() && !isTcExist.isPresent() && GeneralEmailService.checkEmail(jobSeekerRequestDTO.email())){
                JobSeeker jobSeeker = jobSeekerDao.save(jobSeekerMapper.jobSeekerRequestToJobSeeker(jobSeekerRequestDTO));
                return jobSeekerMapper.jobSeekerToJobSeekerResponse(jobSeeker);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    @Override
    public JobSeekerResponseDTO getJobSeekerById(Long jobSeekerId) {

        List<JobSeekerResponseDTO> jobSeekers = getAllJobSeekers();

        Optional<JobSeekerResponseDTO> optionalJobSeeker = jobSeekers.stream().filter(jobSeeker -> jobSeeker.id() == jobSeekerId).findFirst();

        if(optionalJobSeeker.isEmpty()){
            return null;
        }
        return optionalJobSeeker.get();
    }

    @Override
    public Long deleteJobSeekerById(Long jobSeekerId) {

        JobSeekerResponseDTO jobSeeker = getJobSeekerById(jobSeekerId);
        if(jobSeeker != null){
            jobSeekerDao.deleteById(jobSeekerId);
            return jobSeekerId;
        }

        return null;
    }

    @Override
    public JobSeekerResponseDTO updateJobSeekerById(Long jobSeekerId, JobSeekerRequestDTO jobSeekerRequestDTO) {
        JobSeekerResponseDTO jobSeekerCheck = getJobSeekerById(jobSeekerId);
        if(jobSeekerCheck != null){
           jobSeekerDao.deleteById(jobSeekerId);
           return createJobSeeker(jobSeekerRequestDTO);
        }
        return null;
    }

    @Override
    public List<JobSeekerResponseDTO> getAllWithPage(int paneNumber, int pageSize) {

        Pageable page = PageRequest.of(paneNumber,pageSize);

        return jobSeekerDao.findAll(page).getContent().stream().map(js -> jobSeekerMapper.jobSeekerToJobSeekerResponse(js)).collect(Collectors.toList());
    }

    @Override
    public List<JobSeekerResponseDTO> getByFirstNameStartsWith(String jobSeekerName) {

        return jobSeekerDao.getByFirstNameStartsWith(jobSeekerName).stream().map(js -> jobSeekerMapper.jobSeekerToJobSeekerResponse(js)).collect(Collectors.toList());
    }

    @Override
    public List<JobSeekerResponseDTO> getByFirstNameOrLastNameContaining(String jobSeekerFirstName,String jobSeekerLastName) {
        return jobSeekerDao.getByFirstNameOrLastNameContaining(jobSeekerFirstName,jobSeekerLastName).stream().map(js-> jobSeekerMapper.jobSeekerToJobSeekerResponse(js)).collect(Collectors.toList());
    }

}
