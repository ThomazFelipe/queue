package com.unitri.tcc.queue.service;

import com.unitri.tcc.queue.data.model.Company;
import javassist.NotFoundException;

import java.util.List;

public interface CompanyService {

    List< Company > findAll();

    Company getOne( Long id ) throws NotFoundException;

    Company saveAndFlush( Company company );

    void delete( Long id ) throws NotFoundException;
}
