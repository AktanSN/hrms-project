package com.aktansanhal.hrms.dao.abstracts;


import com.aktansanhal.hrms.entity.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployerDao extends JpaRepository<Employer,Long> {

    List<Employer> getByCompanyNameStartsWith(String companyName);

    List<Employer> getByCompanyNameContains(String companyName);

    List<Employer> getAllByOrderByCompanyNameAsc();
}
