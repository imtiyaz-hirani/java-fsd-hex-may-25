package com.springboot.lms.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.lms.dto.CourseEnrollBarDto;
import com.springboot.lms.model.Author;
import com.springboot.lms.model.Course;
import com.springboot.lms.model.LearnerCourse;
import com.springboot.lms.model.User;
import com.springboot.lms.repository.AuthorRepository;
import com.springboot.lms.repository.LearnerCourseRepository;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;
    private UserService userService;
    private CourseService courseService;
    private LearnerCourseRepository learnerCourseRepository;
    Logger logger = LoggerFactory.getLogger(AuthorService.class);

    public AuthorService(AuthorRepository authorRepository, UserService userService, CourseService courseService,
            LearnerCourseRepository learnerCourseRepository) {
        this.authorRepository = authorRepository;
        this.userService = userService;
        this.courseService = courseService;
        this.learnerCourseRepository = learnerCourseRepository;
    }

    public Author postAuthor(Author author) {
        /** Assign role AUTHOR to this user */
        User user = author.getUser();
        user.setRole("AUTHOR");

        /* Fetch User from Author and add to DB */
        user = userService.signUp(author.getUser());

        /* Attach this user to author again */
        author.setUser(user);

        /* Activate Author - later let executive do this.. */
        author.setActive(true);

        /* Save Author in Db */
        return authorRepository.save(author);
    }

    public Author uploadProfilePic(MultipartFile file, String username) throws IOException {
        /* Fetch Author Info by username */
        Author author = authorRepository.getAuthorByUsername(username);
        logger.info("This is author --> " + author.getName());
        /* extension check: jpg,jpeg,png,gif,svg : */
        String originalFileName = file.getOriginalFilename(); // profile_pic.png
        logger.info(originalFileName.getClass().toString());

        String extension = originalFileName.split("\\.")[1]; // png
        if (!(List.of("jpg", "jpeg", "png", "gif", "svg").contains(extension))) {
            logger.error("extension not approved " + extension);
            throw new RuntimeException("File Extension " + extension + " not allowed " + "Allowed Extensions"
                    + List.of("jpg", "jpeg", "png", "gif", "svg"));
        }
        logger.info("extension approved " + extension);
        /* Check the file size */
        long kbs = file.getSize() / 1024;
        if (kbs > 3000) {
            logger.error("File oversize " + kbs);
            throw new RuntimeException("Image Oversized. Max allowed size is " + kbs);
        }
        logger.info("Profile Image Size " + kbs + " KBs");

        /* Check if Directory exists, else create one */
        String uploadFolder = "D:\\fsd hex may 25\\java-fsd-hex-may-25\\React UI\\react-lms-ui\\public\\images";
        Files.createDirectories(Path.of(uploadFolder));
        logger.info(Path.of(uploadFolder) + " directory ready!!!");
        /* Define the full path */
        Path path = Paths.get(uploadFolder, "\\", originalFileName);
        /* Upload file in the above path */
        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        /* Set url of file or image in author object */
        author.setProfilePic(originalFileName);
        /* Save author Object */
        return authorRepository.save(author);
    }

    public Author getAuthorInfo(String username) {
        /* Fetch Author Info by username */
        return authorRepository.getAuthorByUsername(username);
    }

    public CourseEnrollBarDto getCourseEnrollStats(String username, CourseEnrollBarDto dto) {
        List<Course> courses = courseService.getCoursesByAuthor(username);
        // this is list of all enrollment of all author courses
        List<LearnerCourse> list = learnerCourseRepository.getEnrollsByAuthorUsername(username);
        List<String> courseTitles = new ArrayList<>();
        List<Integer> enrolls = new ArrayList<>();

        courses.stream().forEach(c -> {
            long num = list.stream().filter(lc -> lc.getCourse().getId() == c.getId()).count();
            courseTitles.add(c.getTitle());
            enrolls.add((int) num);
        });
        dto.setCourseTitles(courseTitles);
        dto.setEnrolls(enrolls);
        return dto;

    }

}
