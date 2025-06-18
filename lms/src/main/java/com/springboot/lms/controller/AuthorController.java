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

import com.springboot.lms.dto.CourseEnrollBarDto;
import com.springboot.lms.model.Author;
import com.springboot.lms.service.AuthorService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/author")
@CrossOrigin(origins = "http://localhost:5173")
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

    @GetMapping("/get")
    public Author getAuthorInfo(Principal principal) {
        return authorService.getAuthorInfo(principal.getName());
    }

    @GetMapping("/enroll/stats")
    public CourseEnrollBarDto getCourseEnrollStatsForAuthor(Principal principal, CourseEnrollBarDto dto) {
        return authorService.getCourseEnrollStats(principal.getName(), dto);

    }

}
