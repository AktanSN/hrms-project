package com.aktansanhal.hrms.dao.abstracts;

import com.aktansanhal.hrms.entity.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSeekerDao extends JpaRepository<JobSeeker, Long> {
}
