package com.tts.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comments{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    @Column(length = 1000)
    private String entry;

    public Comments() {
    }

    public Comments(String title, String author, String entry) {
        this.title = title;
        this.author = author;
        this.entry = entry;
    }

    public Long getId() {
        return id;
    }

    //no need to set an id

    // public void setId(Long id) {
    //     this.id = id;
    // }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Comments [author=" + author + ", entry=" + entry + ", id=" + id + ", title=" + title + "]";
    }


}