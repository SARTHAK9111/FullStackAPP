package com.example.JobApp.Jobs.Impl;

import com.example.JobApp.Jobs.Job;
import com.example.JobApp.Jobs.JobRepository;
import com.example.JobApp.Jobs.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;

@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private Long nestID = 1l;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setID(nestID++);
        jobRepository.save(job);
    }

    @Override
    public Job findbyId(Long Id) {

         return jobRepository.findById(Id).orElse(null);


    }

    @Override
    public boolean deleteById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(long ID, Job jobToUpdate) {
        Optional<Job> jobOptional = jobRepository.findById(ID);
             // Assuming 'jobs' is a list of Job entities
                if (jobOptional.isPresent()) {
                    Job job = jobOptional.get();// Assuming getId() is the method to get the Job ID
                    job.setTitle(jobToUpdate.getTitle()); // Assuming 'setTitle' and 'getTitle' are methods for job title
                    job.setDescription(jobToUpdate.getDescription()); // Assuming 'setDescription' and 'getDescription' are methods for job description
                    job.setMaxSalary(jobToUpdate.getMaxSalary());
                    job.setMinSalary(jobToUpdate.getMinSalary());
                    job.setLocation(jobToUpdate.getLocation());
                    jobRepository.save(job);// Assuming 'setSalary' and 'getSalary' are methods for job salary
                    // Add more fields to update as necessary
                    return true; // Return true if the job was found and updated
                }
        return false; // Return false if no job with the given ID was found
    }

}
