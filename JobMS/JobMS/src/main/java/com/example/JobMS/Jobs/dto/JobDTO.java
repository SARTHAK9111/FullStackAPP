package com.example.JobMS.Jobs.dto;

import com.example.JobMS.Jobs.External.Review;
import com.example.JobMS.Jobs.External.Company;

import java.util.List;

public class JobDTO {

    private Long ID;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String Location;
    private Long company;
    private Company Company;

    private List<Review> reviews;

    public com.example.JobMS.Jobs.External.Company getCompany() {
        return Company;
    }

    public void setCompany(com.example.JobMS.Jobs.External.Company company) {
        Company = company;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setCompany(Long company) {
        this.company = company;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}

