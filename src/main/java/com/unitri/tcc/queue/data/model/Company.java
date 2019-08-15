package com.unitri.tcc.queue.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table( name = "QUEUE_COMPANY" )
public class Company implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "ID" )
    private Long id;

    @Column( name = "USERNAME" )
    private String username;

    @Column( name = "PASSWORD" )
    private String password;

    @Column( name = "NAME" )
    private String name;

    @Column( name = "CREATED_AT" )
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

    public Company setId( Long id ) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Company setUsername( String username ) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Company setPassword( String password ) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName( String name ) {
        this.name = name;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Company setCreatedAt( Date createdAt ) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Company setUpdatedAt( Date updatedAt ) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Company setCreatedBy( String createdBy ) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public Company setUpdatedBy( String updatedBy ) {
        this.updatedBy = updatedBy;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Company company = ( Company ) o;
        return Objects.equals( id, company.id ) &&
                Objects.equals( username, company.username ) &&
                Objects.equals( password, company.password ) &&
                Objects.equals( name, company.name );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, username, password, name );
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
