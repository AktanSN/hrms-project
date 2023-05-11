package com.aktansanhal.hrms.dao.abstracts;

import com.aktansanhal.hrms.core.utilities.error.DataResult;
import com.aktansanhal.hrms.entity.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobAdvertisementDAO extends JpaRepository<JobAdvertisement, Integer>{


    List<JobAdvertisement> getAllByStatusTrueOrderByStartDateAsc();


    JobAdvertisement getById(int id);

    List<JobAdvertisement> getAllByStatusTrue();

    List<JobAdvertisement> getJobAdvertisementsByEmployer_CompanyName(String companyName);
}
