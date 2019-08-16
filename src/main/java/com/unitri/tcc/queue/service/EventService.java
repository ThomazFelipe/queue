package com.unitri.tcc.queue.service;

import com.unitri.tcc.queue.data.model.Event;
import javassist.NotFoundException;

import java.util.List;

public interface EventService {

    List< Event > findAll();

    Event getOne( Long id ) throws NotFoundException;

    Event saveAndFlush( Event event );

    void delete( Long id ) throws NotFoundException;
}
