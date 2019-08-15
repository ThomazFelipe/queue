package com.unitri.tcc.queue.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Entity
@Table( name = "QUEUE_EVENT" )
public class Event implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "ID" )
    private Long id;

    @Column( name = "NAME" )
    private String name;

    @Column( name = "DESCRIPTION" )
    private String description;

    @Column( name = "INITIAL_DATE" )
    private Date initialDate;

    @Column( name = "FINAL_DATE" )
    private Date finalDate;

    @Column( name = "QR_CODE" )
    private byte[] qrCode;

    @Column( name = "CURRENT_PASSWORD" )
    private Long currentPassword;

    @Column( name = "CREATED_AT" )
    private Date createdAt;

    @Column( name = "UPDATED_AT" )
    private Date updatedAt;

    @Column( name = "CREATED_BY", insertable = false, updatable = false )
    private String createdBy;

    @Column( name = "UPDATED_BY", insertable = false, updatable = false )
    private String updatedBy;

//    @OneToMany
//    private Event event;

    public Long getId() {
        return id;
    }

    public Event setId( Long id ) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Event setName( String name ) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription( String description ) {
        this.description = description;
        return this;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public Event setInitialDate( Date initialDate ) {
        this.initialDate = initialDate;
        return this;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public Event setFinalDate( Date finalDate ) {
        this.finalDate = finalDate;
        return this;
    }

    public byte[] getQrCode() {
        return qrCode;
    }

    public Event setQrCode( byte[] qrCode ) {
        this.qrCode = qrCode;
        return this;
    }

    public Long getCurrentPassword() {
        return currentPassword;
    }

    public Event setCurrentPassword( Long currentPassword ) {
        this.currentPassword = currentPassword;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Event setCreatedAt( Date createdAt ) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Event setUpdatedAt( Date updatedAt ) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Event setCreatedBy( String createdBy ) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Event setUpdatedBy( String updatedBy ) {
        this.updatedBy = updatedBy;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Event event = ( Event ) o;
        return Objects.equals( id, event.id ) &&
                Objects.equals( name, event.name ) &&
                Objects.equals( createdAt, event.createdAt );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, name, createdAt );
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", initialDate=" + initialDate +
                ", finalDate=" + finalDate +
                ", qrCode=" + Arrays.toString( qrCode ) +
                ", currentPassword=" + currentPassword +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
