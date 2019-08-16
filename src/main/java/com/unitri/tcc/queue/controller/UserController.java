package com.unitri.tcc.queue.controller;

import com.unitri.tcc.queue.data.model.User;
import com.unitri.tcc.queue.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping( "/user" )
public class UserController {

    private final UserService service;

    @Autowired
    public UserController( UserService service ) {
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
    public ResponseEntity save( @Valid @RequestBody User user ) {
        return ResponseEntity.ok( service.saveAndFlush( user ) );
    }

    @PutMapping
    public ResponseEntity update( @RequestBody User user ) {
        return ResponseEntity.ok( service.saveAndFlush( user ) );
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
