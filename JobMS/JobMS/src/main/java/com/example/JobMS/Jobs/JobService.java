package com.example.JobMS.Jobs;

import com.example.JobMS.Jobs.dto.JobDTO;

import java.util.List;
public interface  JobService {
    List<JobDTO> findAll();

    void createJob(Job job);
    JobDTO findbyId(Long Id);

    boolean deleteById(Long id );


    boolean updateJob(long id, Job jobToUpdate);
}
