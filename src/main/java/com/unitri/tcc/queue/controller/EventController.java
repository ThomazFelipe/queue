package com.unitri.tcc.queue.controller;

import com.unitri.tcc.queue.data.model.Event;
import com.unitri.tcc.queue.service.EventService;
import com.unitri.tcc.queue.utils.QRCodeUtils;
import com.unitri.tcc.queue.utils.StringUtils;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

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

    @GetMapping( "/{id}/qrcode" )
    public void getQRCode( @PathVariable Long id, HttpServletResponse response ) {

        try {
            response.setContentType( "image/png" );
            OutputStream outputStream = response.getOutputStream();
            outputStream.write( service.getOne(id).getQrCode() );
            outputStream.flush();
            outputStream.close();
        } catch (IOException | NotFoundException e ) {
            System.out.println( e.getMessage() );
        }
    }
}
