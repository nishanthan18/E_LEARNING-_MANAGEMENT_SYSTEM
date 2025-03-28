package com.seceProject.E_learning.Controller;

import com.seceProject.E_learning.Entity.Instructor;
import com.seceProject.E_learning.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/instructors")
@CrossOrigin("*")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    // Create Instructor
    @PostMapping("/register")
    public String createInstructor(@RequestBody Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "Instructor created successfully!";
    }

    // Get All Instructors
    @GetMapping
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    // Get Instructor by ID
    @GetMapping("/{i_id}")
    public Optional<Instructor> getInstructorById(@PathVariable Long i_id) {
        return instructorService.getInstructorById(i_id);
    }

    // Update Instructor
    @PutMapping("/{i_id}")
    public String updateInstructor(@PathVariable Long i_id, @RequestBody Instructor instructor) {
        instructorService.updateInstructor(i_id, instructor);
        return "Instructor updated successfully!";
    }

    // Delete Instructor
    @DeleteMapping("/{i_id}")
    public String deleteInstructor(@PathVariable Long i_id) {
        return instructorService.deleteInstructor(i_id);
    }

   @PostMapping("/login")
    public ResponseEntity<String> instructorLogin(@RequestBody Map<String, String> credentials) {
        String i_email = credentials.get("email");
        String i_password = credentials.get("password");

        if (instructorService.validateInstructorLogin(i_email, i_password)) {
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
}
