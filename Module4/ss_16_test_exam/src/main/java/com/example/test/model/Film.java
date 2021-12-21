package com.example.test.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.beans.IntrospectionException;
import java.util.List;
@Entity
public class Film {
    @Id
    private Integer id;
    private String name;
    @OneToMany(targetEntity = Movies.class, mappedBy = "film")
    List< Movies > customerList;

    public Film(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Film() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
