package com.seceProject.E_learning.Repository;

import com.seceProject.E_learning.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT COUNT(s) FROM Student s JOIN s.courses c WHERE s.id = :id")  // Fixed query
    int getEnrolledCourseCount(@Param("id") Long id);

    Student findByEmail(String email);
}
