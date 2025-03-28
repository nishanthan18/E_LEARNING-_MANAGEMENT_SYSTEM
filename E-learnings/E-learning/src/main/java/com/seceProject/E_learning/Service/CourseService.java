package com.seceProject.E_learning.Service;

import com.seceProject.E_learning.Entity.Course;
import com.seceProject.E_learning.Entity.Student;
import com.seceProject.E_learning.Repository.CourseRepository;
import com.seceProject.E_learning.Repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long c_id) {
        return courseRepository.findById(c_id).orElse(null);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }
    public void deleteCourse(Long c_id) {
        courseRepository.deleteById(c_id);
    }

    @Transactional
    public int getEnrolledStudentCount(Long c_id) {
        return courseRepository.getEnrolledStudentCount(c_id);
    }
}
