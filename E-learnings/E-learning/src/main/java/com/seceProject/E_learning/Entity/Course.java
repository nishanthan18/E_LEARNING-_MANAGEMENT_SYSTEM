package com.seceProject.E_learning.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer c_id;

    @Column(nullable = false, length = 50)
    private String c_type;

    @Column(nullable = false, length = 80)
    private String c_name;

    @Column(nullable = false, length = 300)
    private String c_description;

    @Column(nullable = false, length = 10)
    private String c_year;

    @Column(nullable = false, length = 255)
    private String youtube_url;

    @Column(nullable = false, length = 255)
    private String website_url;


    @ManyToOne
    @JoinColumn(name = "i_id", nullable = false)
    @JsonIgnore
    private Instructor instructor;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students = new ArrayList<>();


    public Course() {}

    public Course(Integer c_id, String c_type, String c_name, String c_description, String c_year, String youtube_url, String website_url) {
        this.c_id = c_id;
        this.c_type = c_type;
        this.c_name = c_name;
        this.c_description = c_description;
        this.c_year = c_year;
        this.youtube_url = youtube_url;
        this.website_url = website_url;

    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_type() {
        return c_type;
    }

    public void setC_type(String c_type) {
        this.c_type = c_type;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_description() {
        return c_description;
    }

    public void setC_description(String c_description) {
        this.c_description = c_description;
    }

    public String getC_year() {
        return c_year;
    }

    public void setC_year(String c_year) {
        this.c_year = c_year;
    }

    public String getYoutube_url() {
        return youtube_url;
    }

    public void setYoutube_url(String youtube_url) {
        this.youtube_url = youtube_url;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
}

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}