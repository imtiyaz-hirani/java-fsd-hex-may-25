package com.springboot.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.lms.exception.ResourceNotFoundException;
import com.springboot.lms.model.Course;
import com.springboot.lms.model.Learner;
import com.springboot.lms.model.LearnerCourse;
import com.springboot.lms.repository.CourseRepository;
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
    @Mock
    private CourseRepository courseRepository;

    private Learner learner;
    private Course course;
    private LearnerCourse learnerCourse;

    @BeforeEach
    public void init() {
        learner = new Learner();
        learner.setId(1);
        learner.setName("Harry Potter");
        learner.setContact("98667434344");

        course = new Course();
        course.setId(1);
        course.setTitle("my course");
        course.setCredits(1000);

        learnerCourse = new LearnerCourse();
        learnerCourse.setId(25);
        learnerCourse.setLearner(learner);
        learnerCourse.setCourse(course);
        learnerCourse.setCouponCode("ABC");
        learnerCourse.setEnrollDate(LocalDate.now());
    }

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
        List<Course> expectedList = List.of(course);

        when(learnerRepository.findById(1)).thenReturn(Optional.of(learner));

        when(learnerCourseRepository.getCourseByLearnerId(1)).thenReturn(expectedList);

        /* Actual call to service method */
        List<Course> actualList = learnerCourseService.getCoursesByLearnerId(1);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void enrollLearnerInCourse() {
        /** Expectation */
        LearnerCourse lc = new LearnerCourse();
        when(learnerRepository.findById(100)).thenReturn(Optional.of(learner));
        when(courseRepository.findById(50)).thenReturn(Optional.of(course));
        when(learnerCourseRepository.save(lc)).thenReturn(learnerCourse);

        /** Actual */
        assertEquals(learnerCourse,
                learnerCourseService.enrollLearnerInCourse(100, 50, lc));

        // use case for invalid learner ID
        ResourceNotFoundException e = assertThrows(ResourceNotFoundException.class,
                () -> learnerCourseService.enrollLearnerInCourse(99, 50, lc));
        assertEquals("Learner ID Invalid".toLowerCase(), e.getMessage().toLowerCase());

        // use case for invalid course ID
        e = assertThrows(ResourceNotFoundException.class,
                () -> learnerCourseService.enrollLearnerInCourse(100, 49, lc));
        assertEquals("Course ID Invalid".toLowerCase(), e.getMessage().toLowerCase());
    }
}
