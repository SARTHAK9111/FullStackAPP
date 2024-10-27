package com.example.JobMS.Jobs;

import com.example.JobMS.Jobs.dto.JobDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
class JobController{

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>> findall(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
       jobService.createJob(job);
        return  new ResponseEntity<>("Job Added Successfully" ,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobByID(@PathVariable Long id){

        JobDTO jobWithCompanyDTO = jobService.findbyId(id);

        if(jobWithCompanyDTO == null){
            return new ResponseEntity<>(  HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jobWithCompanyDTO , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long Id) {
        boolean flag = jobService.deleteById(Id);
        if(flag){
            return new ResponseEntity<>("Job Delete Successfully" , HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Delete NoT Found" , HttpStatus.NOT_FOUND);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Job updateJob) {
        boolean flag = jobService.updateJob(id, updateJob);

        if (flag) {
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);
    }




}