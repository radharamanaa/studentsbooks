package com.appl.entities;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@ComponentScan
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @NotNull
    @Column(length = 10)
    String studentId;

    @NotNull
    String name;

    @OneToMany(mappedBy = "studentId")
    List<Book> Books;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }
}
