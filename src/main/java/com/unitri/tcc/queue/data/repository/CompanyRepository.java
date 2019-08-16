package com.unitri.tcc.queue.data.repository;

import com.unitri.tcc.queue.data.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository< Company, Long > {
}
