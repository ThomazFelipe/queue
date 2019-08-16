package com.unitri.tcc.queue.controller;

import com.unitri.tcc.queue.data.model.Company;
import com.unitri.tcc.queue.service.CompanyService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/company" )
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController( CompanyService service ) {
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
    public ResponseEntity save( @RequestBody Company company ) {
        return ResponseEntity.ok( service.saveAndFlush( company ) );
    }

    @PutMapping
    public ResponseEntity update( @RequestBody Company company ) {
        return ResponseEntity.ok( service.saveAndFlush( company ) );
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
