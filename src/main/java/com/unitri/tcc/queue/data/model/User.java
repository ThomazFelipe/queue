package com.unitri.tcc.queue.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table( name = "QUEUE_USER" )
public class User implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "ID" )
    private Long id;

    @Column( name = "NAME" )
    private String name;

    @Pattern( regexp = "^[0-9]{10,11}$" )
    @Column( name = "PHONE" )
    private String phone;

    @Column( name = "PASSWORD_NUMBER" )
    private Long passwordNumber;

    @Column( name = "CONFIRMATION_CODE" )
    private String confirmationCode;

    @Column( name = "CREATED_BY" )
    private Date createdAt;

    @Column( name = "UPDATED_AT" )
    private Date updatedAt;

    @Column( name = "CREATED_BY", insertable = false, updatable = false )
    private String createdBy;

    @Column( name = "UPDATED_BY", insertable = false, updatable = false )
    private String updatedBy;

    @JsonIgnore
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "EVENT_ID", referencedColumnName = "ID" )
    private Event event;

    public Long getId() {
        return id;
    }

    public User setId( Long id ) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName( String name ) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone( String phone ) {
        this.phone = phone;
        return this;
    }

    public Long getPasswordNumber() {
        return passwordNumber;
    }

    public User setPasswordNumber( Long passwordNumber ) {
        this.passwordNumber = passwordNumber;
        return this;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public User setConfirmationCode( String confirmationCode ) {
        this.confirmationCode = confirmationCode;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User setCreatedAt( Date createdAt ) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public User setUpdatedAt( Date updatedAt ) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public User setCreatedBy( String createdBy ) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public User setUpdatedBy( String updatedBy ) {
        this.updatedBy = updatedBy;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public User setEvent( Event event ) {
        this.event = event;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        User user = (User) o;
        return Objects.equals( id, user.id ) &&
                Objects.equals( phone, user.phone ) &&
                Objects.equals( passwordNumber, user.passwordNumber );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, phone, passwordNumber );
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", passwordNumber=" + passwordNumber +
                ", confirmationCode='" + confirmationCode + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
