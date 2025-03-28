package com.seceProject.E_learning.Controller;

import com.seceProject.E_learning.Entity.Student;
import com.seceProject.E_learning.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        try {
            Student savedStudent = studentService.saveStudent(student);
            return ResponseEntity.ok(savedStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get()); // ✅ Correct
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found"); // ❌ Potential Issue
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.ok("Student updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully!");
    }

    @PostMapping("/{id}/enroll/{c_id}")
    public ResponseEntity<String> enrollInCourse(@PathVariable Long id, @PathVariable Long c_id) {
        studentService.enrollStudentInCourse(id, c_id);
        return ResponseEntity.ok("Student enrolled in the course successfully!");
    }

    @GetMapping("/{id}/enrolledCoursesCount")
    public ResponseEntity<Integer> getEnrolledCourseCount(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getEnrolledCourseCount(id));
    }

    @PostMapping("/login")
    public ResponseEntity<String> studentLogin(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (studentService.validateStudentLogin(email, password)) {
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
}
