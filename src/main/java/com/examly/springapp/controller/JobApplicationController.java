package com.examly.springapp.controller;
import com.examly.springapp.model.JobApplication;
import com.examly.springapp.service.JobApplicationService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {
  private final JobApplicationService jobApplicationService;

  public JobApplicationController(JobApplicationService jobApplicationService){
   this.jobApplicationService=jobApplicationService;
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<String> getJobApplicationById(@PathVariable Long id){
   JobApplication jobApplication = jobApplicationService.getJobApplicationById(id);
   if(jobApplication != null){
     return ResponseEntity.status(HttpStatus.OK).body("Job application found");
   } else {
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job application not found");
   }
  }

   @GetMapping
  public ResponseEntity<List<JobApplication>> getAllJobApplication(){
   List<JobApplication> jobApplications = jobApplicationService.getAllJobApplications();
   if(jobApplications.isEmpty()){
     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }
   return ResponseEntity.status(HttpStatus.OK).body(jobApplications);
  }

  @GetMapping("/paginated")
  public ResponseEntity<Page<JobApplication>> getJobApplicationsWithPagination(
     @RequestParam(defaultValue = "0") int page,
     @RequestParam(defaultValue = "10") int size,
     @RequestParam(defaultValue = "applicationId") String sortBy){
   Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
   Page<JobApplication> jobApplications = jobApplicationService.getJobApplicationsWithPagination(pageable);
   return ResponseEntity.ok(jobApplications);
  }

@PostMapping
public ResponseEntity<JobApplication> createJobApplication(
        @RequestBody(required = false) JobApplication jobApplication) {

    if (jobApplication == null) {
        return ResponseEntity.badRequest().build();
    }

    JobApplication saved = jobApplicationService.createJobApplication(jobApplication);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id){
   JobApplication existing = jobApplicationService.getJobApplicationById(id);
   if(existing == null){
     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }
   jobApplicationService.deleteJobApplication(id);
   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<JobApplication> updateJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication){
   JobApplication updated = jobApplicationService.updateJobApplication(id, jobApplication);
   if(updated == null){
     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
   }
   return ResponseEntity.status(HttpStatus.OK).body(updated);
  }
}

