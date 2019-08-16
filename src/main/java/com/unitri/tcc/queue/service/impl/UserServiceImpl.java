package com.unitri.tcc.queue.service.impl;

import com.unitri.tcc.queue.data.model.User;
import com.unitri.tcc.queue.data.repository.UserRepository;
import com.unitri.tcc.queue.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl( UserRepository repository ) {
        this.repository = repository;
    }

    @Override
    public List< User > findAll() {
        return repository.findAll();
    }

    @Override
    public User getOne( Long id ) throws NotFoundException {
        if ( !repository.existsById( id ) ) {
            throw new NotFoundException( "User not found" );
        }
        return repository.getOne( id );
    }

    @Override
    public User saveAndFlush( User user ) {
        if ( Objects.nonNull( user.getId() ) ) {
            user.setUpdatedAt( new Date() )
                    .setUpdatedBy( "" );
        } else {
            user.setCreatedAt( new Date() )
                    .setCreatedBy( "" );
        }
        return repository.saveAndFlush( user );
    }

    @Override
    public void delete( Long id ) throws NotFoundException {
        if ( !repository.existsById( id ) ) {
            throw new NotFoundException( "User not found" );
        }
        repository.deleteById( id );
    }
}
