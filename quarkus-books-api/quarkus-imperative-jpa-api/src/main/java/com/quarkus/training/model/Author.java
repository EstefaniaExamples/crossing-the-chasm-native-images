package com.quarkus.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name="authors")
public class Author extends PanacheEntity {
    public String name;
    public String surname;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    @JsonIgnore
    // We mark this property with @JsonIgnore to avoid infinite loops when serializing with Jackson.
    public Set<Book> books = new HashSet<>();
}
