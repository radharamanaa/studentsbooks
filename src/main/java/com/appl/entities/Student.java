package com.appl.entities;

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
    String name;

    @OneToMany(mappedBy = "studentId")
    List<Book> Books;
}
