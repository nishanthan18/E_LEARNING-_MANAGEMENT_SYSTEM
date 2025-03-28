package com.seceProject.E_learning.Controller;

import com.seceProject.E_learning.Entity.Course;
import com.seceProject.E_learning.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{c_id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long c_id) {
        Course course = courseService.getCourseById(c_id);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public String addCourse(@RequestBody Course course) {
        courseService.saveCourse(course);
        return "Course added successfully!";
    }



    @DeleteMapping("/{c_id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long c_id) {
        courseService.deleteCourse(c_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{c_id}/studentCount")
    public int getEnrolledStudentCount(@PathVariable Long c_id) {
        return courseService.getEnrolledStudentCount(c_id);
    }
}
