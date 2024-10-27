package com.example.JobMS.Jobs.Mapper;

import com.example.JobMS.Jobs.External.Company;
import com.example.JobMS.Jobs.External.Review;
import com.example.JobMS.Jobs.Job;
import com.example.JobMS.Jobs.dto.JobDTO;


import java.util.List;

public class JobMapper {

    public static JobDTO mapToJobWithComapnyDTO (Job job , Company company , List<Review> reviews){


        JobDTO jobWithCompanyDTO = new JobDTO();

        jobWithCompanyDTO.setID(job.getID());
        jobWithCompanyDTO.setTitle(job.getTitle());
        jobWithCompanyDTO.setDescription(job.getDescription());
        jobWithCompanyDTO.setLocation(job.getLocation());
        jobWithCompanyDTO.setMaxSalary(job.getMaxSalary());
        jobWithCompanyDTO.setMinSalary(job.getMinSalary());
        jobWithCompanyDTO.setCompany(company);
        jobWithCompanyDTO.setReviews(reviews);

        return jobWithCompanyDTO;
    }

}
