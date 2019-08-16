package com.unitri.tcc.queue.controller;

import com.unitri.tcc.queue.data.model.Event;
import com.unitri.tcc.queue.service.EventService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/event" )
public class EventController {

    private final EventService service;

    @Autowired
    public EventController( EventService service ) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok( service.findAll() );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity getOne( @PathVariable Long id ) {
        try {
            return ResponseEntity.ok( service.getOne( id ) );
        } catch ( NotFoundException e ) {
            return ResponseEntity.badRequest().body( e.getMessage() );
        }
    }

    @PostMapping
    public ResponseEntity save( @RequestBody Event event ) {
        return ResponseEntity.ok( service.saveAndFlush( event ) );
    }

    @PutMapping
    public ResponseEntity update( @RequestBody Event event ) {
        return ResponseEntity.ok( service.saveAndFlush( event ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity delete( @PathVariable Long id ) {
        try {
            service.delete( id );
            return ResponseEntity.ok().build();
        } catch ( NotFoundException e ) {
            return ResponseEntity.badRequest().body( e.getMessage() );
        }
    }
}
