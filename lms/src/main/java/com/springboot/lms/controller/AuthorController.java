package com.springboot.lms.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.lms.model.Author;
import com.springboot.lms.service.AuthorService;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    /**
     * @aim To insert author info with its user credentails
     * @param author
     * @return Author
     * @path /api/author/add
     */
    @PostMapping("/add")
    public Author postAuthor(@RequestBody Author author) {
        return authorService.postAuthor(author);
    }

    @PostMapping("/uplad/profile-pic")
    public Author uploadProfilePic(Principal principal, @RequestParam("file") MultipartFile file) throws IOException {
        return authorService.uploadProfilePic(file, principal.getName());
    }

}
