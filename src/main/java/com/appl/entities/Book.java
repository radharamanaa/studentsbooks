package com.appl.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "BookName",length = 30)
    String title;

    @Column(name = "AUTHOR",length = 30)
    String author;

    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    Student studentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
