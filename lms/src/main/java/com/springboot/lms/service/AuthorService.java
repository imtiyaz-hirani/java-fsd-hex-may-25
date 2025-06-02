package com.springboot.lms.service;

import org.springframework.stereotype.Service;

import com.springboot.lms.model.Author;
import com.springboot.lms.repository.AuthorRepository;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author postAuthor(Author author) {
        // Todo
        throw new UnsupportedOperationException("Unimplemented method 'postAuthor'");
    }

}
