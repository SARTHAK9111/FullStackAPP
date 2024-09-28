package com.example.JobApp.Company;

import com.example.JobApp.Jobs.Job;
import com.example.JobApp.Reviews.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;

    public Company(Long id, String name, String description) {
        Id = id;
        this.name = name;
        Description = description;

    }

    private String Description;

    @JsonIgnore
    @OneToMany(mappedBy ="company")
    private List<Job> jobs;

    @OneToMany(mappedBy ="company")
    private List<Review> Review;

    public Company() {
    }

    public Long getId() {
        return Id;
    }

    public List<Review> getReview() {
        return Review;
    }

    public void setReview(List<Review> review) {
        Review = review;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
