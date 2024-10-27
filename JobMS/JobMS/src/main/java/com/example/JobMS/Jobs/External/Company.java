package com.example.JobMS.Jobs.External;



public class Company {


    private Long Id;
    private String name;

    public Company(Long id, String name, String description) {
        Id = id;
        this.name = name;
        Description = description;

    }

    private String Description;


    public Company() {
    }

    public Long getId() {
        return Id;
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


}
