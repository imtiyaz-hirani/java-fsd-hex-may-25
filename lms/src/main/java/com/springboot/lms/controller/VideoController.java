package com.springboot.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lms.model.Video;
import com.springboot.lms.service.VideoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/video")
@CrossOrigin(origins = "http://localhost:5173")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * @path /api/video/add
     * @param @RequestBody List<Video>
     * @return ResponseEntity
     * @method POST
     */
    @PostMapping("/add/{moduleId}")
    public ResponseEntity<?> batchInsert(@RequestBody List<Video> list,
            @PathVariable("moduleId") int moduleId) {
        videoService.batchInsert(list, moduleId);
        return ResponseEntity.ok().body("Operation Comleted!!!");
    }

    /**
     * @path /api/video/getAll
     * @param @PathVariable courseId
     * @return ResponseEntity - Videos with Modules
     * @method GET
     */
    @GetMapping("/getAll/{courseId}")
    public List<Video> getAllVideosWithModules(@PathVariable("courseId") int courseId) {
        return videoService.getAllVideosWithModules(courseId);
    }
}
