package com.example.ReviewMS.Reviews.dto;

public class ReviewMessge {
    private Long id;
    private String titile;
    private String description;
    private double rating;
    private Long conpanyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getConpanyId() {
        return conpanyId;
    }

    public void setConpanyId(Long conpanyId) {
        this.conpanyId = conpanyId;
    }
}
