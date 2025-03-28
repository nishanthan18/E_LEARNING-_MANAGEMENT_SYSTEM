package com.seceProject.E_learning.Service;

import com.seceProject.E_learning.Entity.Course;
import com.seceProject.E_learning.Entity.Student;
import com.seceProject.E_learning.Repository.CourseRepository;
import com.seceProject.E_learning.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public Student saveStudent(Student student) {
        if (studentRepository.findByEmail(student.getEmail()) != null) {
            throw new RuntimeException("Email already exists!");
        }
        return studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Long id, Student student) {
        student.setId(id);
        studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void enrollStudentInCourse(Long id, Long c_id) {
        Optional<Student> student = studentRepository.findById(id);
        Optional<Course> course = courseRepository.findById(c_id);
        if (student.isPresent() && course.isPresent()) {
            student.get().getCourses().add(course.get());
            studentRepository.save(student.get());  // Added save to persist changes
        }
    }

    @Transactional
    public int getEnrolledCourseCount(Long id) {
        return studentRepository.getEnrolledCourseCount(id);
    }

    public boolean validateStudentLogin(String email, String password) {
        Student student = studentRepository.findByEmail(email);
        return student != null && student.getPassword().equals(password);
    }
}
