package com.unitri.tcc.queue.service.impl;

import com.unitri.tcc.queue.data.model.Event;
import com.unitri.tcc.queue.data.repository.EventRepository;
import com.unitri.tcc.queue.service.EventService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repository;

    @Autowired
    public EventServiceImpl( EventRepository repository ) {
        this.repository = repository;
    }

    @Override
    public List< Event > findAll() {
        return repository.findAll();
    }

    @Override
    public Event getOne( Long id ) throws NotFoundException {
        if ( !repository.existsById( id ) ) {
            throw new NotFoundException( "Event not found" );
        }
        return repository.getOne( id );
    }

    @Override
    public Event saveAndFlush( Event event ) {
        if ( Objects.nonNull( event.getId() ) ) {
            event.setUpdatedAt( new Date() )
                    .setUpdatedBy( "" );
        } else {
            event.setCreatedAt( new Date() )
                    .setCreatedBy( "" );
        }
        return repository.saveAndFlush( event );
    }

    @Override
    public void delete( Long id ) throws NotFoundException {
        if ( !repository.existsById( id ) ) {
            throw new NotFoundException( "Event not found" );
        }
        repository.deleteById( id );
    }
}
