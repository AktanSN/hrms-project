package com.aktansanhal.hrms.dao.abstracts;

import com.aktansanhal.hrms.entity.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition,Long> {
}
