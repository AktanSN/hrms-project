package com.aktansanhal.hrms.dao.abstracts;

import com.aktansanhal.hrms.entity.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPositionDao extends JpaRepository<JobPosition,Long> {

    List<JobPosition> getByPositionNameStartingWith(String positionName);

    List<JobPosition> getByPositionNameContains(String positionName);

    List<JobPosition> getAllByOrderByPositionNameAsc();
}
