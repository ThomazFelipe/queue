package com.unitri.tcc.queue.service;

import com.unitri.tcc.queue.data.model.User;
import javassist.NotFoundException;

import java.util.List;

public interface UserService {

    List< User > findAll();

    User getOne( Long id ) throws NotFoundException;

    User saveAndFlush( User user );

    void delete( Long id ) throws NotFoundException;
}
