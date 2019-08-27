package com.unitri.tcc.queue.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table( name = "QUEUE_FIELD" )
public class Field implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "ID" )
    private Long id;

    @Column( name = "TYPE" )
    @Enumerated( EnumType.STRING )
    @NotNull
    private TypeFieldEnum type;

    @Column( name = "NAME" )
    @NotNull
    private String name;

    @Column( name = "VALUE" )
    @NotNull
    private String value;

    @JsonIgnore
    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "EVENT_ID", referencedColumnName = "ID" )
    private Event event;

    public Long getId() {
        return id;
    }

    public Field setId( Long id ) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Field setName( String name ) {
        this.name = name;
        return this;
    }

    public TypeFieldEnum getType() {
        return type;
    }

    public Field setType( TypeFieldEnum type ) {
        this.type = type;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Field setValue( String value ) {
        this.value = value;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public Field setEvent( Event event ) {
        this.event = event;
        return this;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Field field = ( Field ) o;
        return Objects.equals( id, field.id ) &&
                Objects.equals( name, field.name );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, name );
    }
}
