package com.example.JobMS.Jobs.Impl;


import com.example.JobMS.Jobs.External.Company;
import com.example.JobMS.Jobs.External.Review;
import com.example.JobMS.Jobs.Job;
import com.example.JobMS.Jobs.JobRepository;
import com.example.JobMS.Jobs.JobService;
import com.example.JobMS.Jobs.Mapper.JobMapper;
import com.example.JobMS.Jobs.clients.CompanyClient;
import com.example.JobMS.Jobs.clients.ReviewClient;
import com.example.JobMS.Jobs.dto.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs = new ArrayList<>();

    JobRepository jobRepository;
    @Autowired
    RestTemplate restTemplate ;

    private CompanyClient companyClient;
    private ReviewClient reviewclient;

    public JobServiceImpl(JobRepository jobRepository , CompanyClient companyClient , ReviewClient reviewclient) {
        this.jobRepository = jobRepository;
        this.companyClient = companyClient;
        this.reviewclient = reviewclient;
    }

    private Long nestID = 1l;
    @Override
    public List<JobDTO> findAll() {
         List<Job> jobs = jobRepository.findAll();
         List<JobDTO> jobWithCompanyDTOS = new ArrayList<>();

        return jobs.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private JobDTO convertToDto(Job job){



        Company comapny = companyClient.getCompany(job.getCompany());


        List<Review> reviews = reviewclient.getReview( job.getCompany());

       JobDTO jobDTO = JobMapper.mapToJobWithComapnyDTO(job,comapny ,reviews);

        return jobDTO;
    }

    @Override
    public void createJob(Job job) {
        job.setID(nestID++);
        jobRepository.save(job);
    }

    @Override
    public JobDTO findbyId(Long Id) {

         Job job = jobRepository.findById(Id).orElse(null);
         return convertToDto(job);


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
