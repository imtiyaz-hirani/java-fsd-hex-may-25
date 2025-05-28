package com.springboot.lms.controller;

import com.springboot.lms.model.Learner;
import com.springboot.lms.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LearnerController {

    @Autowired
    private LearnerService learnerService;
     
    /*
     * PATH: http://localhost:8080/api/learner/add
     * Response: Hello Rest API!!!
     * */
    @PostMapping("/api/learner/add")
    public Learner insertLearner(@RequestBody Learner learner) {
        return learnerService.insertLearner(learner);
    }

    /*
     * AIM: To fetch all learner records
     * PATH: /api/learner/get-all
     * Method: GET
     * Response: List<Learner>
     * */
    @GetMapping("/api/learner/get-all")
    public ResponseEntity<?> getAll() {
    	return ResponseEntity
    			.status(HttpStatus.OK)
    			.body(learnerService.getAll());
    }

    /*
     * AIM: To delete learner by id
     * PATH: /api/learner/delete
     * METHOD: delete
     * response: void
     * Input: id - PathVariable
     * */
    @DeleteMapping("/api/learner/delete/{id}")
    public ResponseEntity<?> deleteLearner(@PathVariable int id) {
        learnerService.deleteLearner(id);
        return ResponseEntity.status(HttpStatus.OK).body("Learner deleted"); 
    }

    /*
     * AIM: Get Learner By Id
     * PATH: /api/learner/get-one/{id}
     * Method: GET
     * Response: Learner
     * Input: id
     * */
    @GetMapping("/api/learner/get-one/{id}")
    public ResponseEntity<?> getLearnerById(@PathVariable int id) {
    	try {
    		return ResponseEntity
    				.status(HttpStatus.OK)
    				.body(learnerService.getLearnerById(id));
    	}
    	catch(Exception e){
    		return ResponseEntity
    				.status(HttpStatus.NOT_FOUND)
    				.body(e.getMessage());
    	}
    }

    /*
     * AIM: Update Learner
     * PATH: /api/learner/update/{id}
     * Body: updated learner
     * METHOD: PUT
     * response: updated learner
     * input: id as path variable , learner as request body
     * */
    @PutMapping("/api/learner/update/{id}")
    public Learner updateLearner(@PathVariable int id, @RequestBody Learner updatedLearner) {
        return learnerService.updateLearner(id, updatedLearner);
    }
}
/* 
 * {
    "name":"Harry Potter",
    "contact" : "9866746558"
	}
	
	Jackson Dependency 
	
	Learner learner = new Learner(); 
	learner.setName(name)
	learner.setContact(contact)
 * 
 */