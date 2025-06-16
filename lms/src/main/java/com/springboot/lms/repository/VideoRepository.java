package com.springboot.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.lms.model.Video;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    // @Query("select v from Video v join v.module m join m.course c where c.id=?1")
    @Query("select v from Video v where v.module.course.id=?1")
    List<Video> getAllVideosWithModules(int courseId);

}
