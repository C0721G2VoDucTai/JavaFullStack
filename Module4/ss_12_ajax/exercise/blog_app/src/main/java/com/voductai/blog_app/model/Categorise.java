package com.voductai.blog_app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="categorise")
public class Categorise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(targetEntity = Blog.class, mappedBy = "categorise")
    private List< Blog > blogList;
    public Categorise() {
    }

    public Categorise(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public List< Blog > getBlogList() {
        return blogList;
    }

    public void setBlogList(List< Blog > blogList) {
        this.blogList = blogList;
    }
}
