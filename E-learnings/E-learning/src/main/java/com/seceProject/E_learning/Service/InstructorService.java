package com.seceProject.E_learning.Service;

import com.seceProject.E_learning.Entity.Instructor;
import com.seceProject.E_learning.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    // Create Instructor
    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Get all instructors
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    // Get Instructor by ID
    public Optional<Instructor> getInstructorById(Long i_id) {
        return instructorRepository.findById(i_id);
    }

    // Update Instructor
    public Instructor updateInstructor(Long i_id, Instructor updatedInstructor) {
        return instructorRepository.findById(i_id).map(instructor -> {
            instructor.setI_name(updatedInstructor.getI_name());
            instructor.setI_email(updatedInstructor.getI_email());
            instructor.setI_phone(updatedInstructor.getI_phone());
            instructor.setI_password(updatedInstructor.getI_password());
            instructor.setSpecialization(updatedInstructor.getSpecialization());
            instructor.setInstitution_name(updatedInstructor.getInstitution_name());
            return instructorRepository.save(instructor);
        }).orElseThrow(() -> new RuntimeException("Instructor not found with id: " + i_id));
    }

    // Delete Instructor
    public String deleteInstructor(Long i_id) {
        if (instructorRepository.existsById(i_id)) {
            instructorRepository.deleteById(i_id);
            return "Instructor deleted successfully!";
        } else {
            throw new RuntimeException("Instructor not found with id: " + i_id);
        }
    }

    public boolean validateInstructorLogin(String i_email, String i_password) {
        Instructor instructor = instructorRepository.findByIEmail(i_email);
        return instructor != null && instructor.getI_password().equals(i_password);
    }
}
