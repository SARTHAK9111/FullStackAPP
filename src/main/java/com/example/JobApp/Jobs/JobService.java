package com.example.JobApp.Jobs;

import  java.util.*;
public interface JobService {
    List<Job> findAll();

    void createJob(Job job);
    Job findbyId(Long Id);

    boolean deleteById(Long id );


    boolean updateJob(long id, Job jobToUpdate);
}
