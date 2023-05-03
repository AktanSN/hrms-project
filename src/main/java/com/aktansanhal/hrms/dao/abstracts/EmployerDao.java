package com.aktansanhal.hrms.dao.abstracts;


import com.aktansanhal.hrms.entity.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerDao extends JpaRepository<Employer,Long> {
}
