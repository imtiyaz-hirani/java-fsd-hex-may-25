package com.springboot.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.lms.model.Course;
import com.springboot.lms.model.Learner;
import com.springboot.lms.repository.LearnerCourseRepository;
import com.springboot.lms.repository.LearnerRepository;
import com.springboot.lms.service.LearnerCourseService;

@SpringBootTest
public class LearnerCourseServiceTest {

    @InjectMocks
    private LearnerCourseService learnerCourseService;
    @Mock
    private LearnerRepository learnerRepository;
    @Mock
    private LearnerCourseRepository learnerCourseRepository;

    // @Test
    public void getCoursesByLearnerIdTest() {
        /* Prepare the expected output */
        Course course = new Course();
        course.setId(1);
        course.setTitle("Core Java - Enterprise Development");
        course.setCredits(50);

        List<Course> expectedList = List.of(course);

        /* Actual call to service method */
        List<Course> actualList = learnerCourseService.getCoursesByLearnerId(1);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void getCoursesByLearnerIdTestMock() {
        /* Prepare mocked excepted result */
        Learner learner = new Learner();
        learner.setId(1);
        learner.setName("Harry Potter");
        learner.setContact("98667434344");

        Course course = new Course();
        course.setId(1);
        course.setTitle("my course");
        course.setCredits(1000);
        List<Course> expectedList = List.of(course);

        when(learnerRepository.findById(1)).thenReturn(Optional.of(learner));

        when(learnerCourseRepository.getCourseByLearnerId(1)).thenReturn(expectedList);

        /* Actual call to service method */
        List<Course> actualList = learnerCourseService.getCoursesByLearnerId(1);

        assertEquals(expectedList, actualList);
    }
}
