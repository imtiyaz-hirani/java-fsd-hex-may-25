package com.springboot.lms.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CourseEnrollBarDto {

    private List<String> courseTitles;
    private List<Integer> enrolls;

    public List<String> getCourseTitles() {
        return courseTitles;
    }

    public void setCourseTitles(List<String> courseTitles) {
        this.courseTitles = courseTitles;
    }

    public List<Integer> getEnrolls() {
        return enrolls;
    }

    public void setEnrolls(List<Integer> enrolls) {
        this.enrolls = enrolls;
    }

}
