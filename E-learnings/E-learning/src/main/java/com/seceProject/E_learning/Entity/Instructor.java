package com.seceProject.E_learning.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long i_id;

    @Column(nullable = false, length = 50)
    private String i_name;

    @Column(unique = true, nullable = false, length = 100)
    private String i_email;

    @Column(nullable = false, length = 20)
    private String i_phone;

    @Column(nullable = false, length = 100)
    private String i_password;

    @Column(nullable = false, length = 50)
    private String specialization;

    @Column(nullable = false, length = 100)
    private String institution_name;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Course> courses;

    public Instructor() {}

    public Instructor(Long i_id, String i_name, String i_email, String i_phone, String i_password, String specialization, String institution_name) {
        this.i_id = i_id;
        this.i_name = i_name;
        this.i_email = i_email;
        this.i_phone = i_phone;
        this.i_password = i_password;
        this.specialization = specialization;
        this.institution_name = institution_name;
    }

    public Long getI_id() {
        return i_id;
    }

    public void setI_id(Long i_id) {
        this.i_id = i_id;
    }

    public String getI_name() {
        return i_name;
    }

    public void setI_name(String i_name) {
        this.i_name = i_name;
    }

    public String getI_email() {
        return i_email;
    }

    public void setI_email(String i_email) {
        this.i_email = i_email;
    }

    public String getI_phone() {
        return i_phone;
    }

    public void setI_phone(String i_phone) {
        this.i_phone = i_phone;
    }

    public String getI_password() {
        return i_password;
    }

    public void setI_password(String i_password) {
        this.i_password = i_password;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getInstitution_name() {
        return institution_name;
    }

    public void setInstitution_name(String institution_name) {
        this.institution_name = institution_name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

}
