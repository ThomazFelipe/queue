package com.unitri.tcc.queue.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
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

    @Column( name = "PHONE" )
    private String phone;

    @Column( name = "PASSWORD_NUMBER" )
    private Long passwordNumber;

    @Column( name = "CODE" )
    private String code;

    @Column( name = "CREATED_BY" )
    private Date createdAt;

    @Column( name = "UPDATED_AT" )
    private Date updatedAt;

    @Column( name = "CREATED_BY", insertable = false, updatable = false )
    private String createdBy;

    @Column( name = "UPDATED_BY", insertable = false, updatable = false )
    private String updatedBy;

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

    public String getCode() {
        return code;
    }

    public User setCode( String code ) {
        this.code = code;
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

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        User user = ( User ) o;
        return Objects.equals( id, user.id ) &&
                Objects.equals( name, user.name ) &&
                Objects.equals( phone, user.phone ) &&
                Objects.equals( passwordNumber, user.passwordNumber ) &&
                Objects.equals( code, user.code );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, name, phone, passwordNumber, code );
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", passwordNumber=" + passwordNumber +
                ", code='" + code + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
