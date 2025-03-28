package com.seceProject.E_learning.Repository;

import com.seceProject.E_learning.Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    @Query("SELECT i FROM Instructor i WHERE i.i_email = :i_email")
    Instructor findByIEmail(@Param("i_email") String i_email);

}

