package com.voductai.blog_app.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank (message = "Name is not empty")
    private String name;
    @NotBlank (message = "Content is not empty")
    @Size(min=10, max=100)
    private String content;
    @Pattern(regexp = "^([A-Z][a-z1-9]*\\s?)*$", message = "Wrong format, Please capitalize the first letter")
    private String note;
    @ManyToOne(targetEntity = Categorise.class)
    @NotNull (message = "Categorise is not empty")
    private Categorise categorise;
    public Blog() {
    }

    public Blog(String name, String content, String note, Categorise categorise) {
        this.name = name;
        this.content = content;
        this.note = note;
        this.categorise = categorise;
    }

    public Blog(Integer id, String name, String content, String note) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.note = note;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Categorise getCategorise() {
        return categorise;
    }

    public void setCategorise(Categorise categorise) {
        this.categorise = categorise;
    }
}
