package com.seceProject.E_learning.Repository;

import com.seceProject.E_learning.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT COUNT(s) FROM Student s JOIN s.courses c WHERE c.c_id = :c_id")
    int getEnrolledStudentCount(@Param("c_id") Long c_id);

}
