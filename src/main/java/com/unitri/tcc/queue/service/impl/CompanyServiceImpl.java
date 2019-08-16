package com.unitri.tcc.queue.service.impl;

import com.unitri.tcc.queue.data.model.Company;
import com.unitri.tcc.queue.data.repository.CompanyRepository;
import com.unitri.tcc.queue.service.CompanyService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl( CompanyRepository repository ) {
        this.repository = repository;
    }

    @Override
    public List< Company > findAll() {
        return repository.findAll();
    }

    @Override
    public Company getOne( Long id ) throws NotFoundException {
        if ( !repository.existsById( id ) ) {
            throw new NotFoundException( "Company not found" );
        }
        return repository.getOne( id );
    }

    @Override
    public Company saveAndFlush( Company company ) {
        if ( Objects.nonNull( company.getId() ) ) {
            company.setUpdatedAt( new Date() )
                    .setUpdatedBy( "" );
        } else {
            company.setCreatedAt( new Date() )
                    .setCreatedBy( "" );
        }
        return repository.saveAndFlush( company );
    }

    @Override
    public void delete( Long id ) throws NotFoundException {
        if ( !repository.existsById( id ) ) {
            throw new NotFoundException( "Company not found" );
        }
        repository.deleteById( id );
    }
}
