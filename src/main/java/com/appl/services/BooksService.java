package com.appl.services;

import com.appl.repos.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {


    BooksRepo repo;

    public BooksRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(BooksRepo repo) {
        this.repo = repo;
    }
}
