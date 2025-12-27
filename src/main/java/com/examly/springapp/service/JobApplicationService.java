package com.examly.springapp.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.examly.springapp.model.JobApplication;

public interface JobApplicationService{
  JobApplication getJobApplicationById(Long id);
  JobApplication createJobApplication(JobApplication jobApplication);
  List<JobApplication> getAllJobApplications();
  JobApplication updateJobApplication(Long id, JobApplication jobApplication);
  void deleteJobApplication(Long id);
  Page<JobApplication> getJobApplicationsWithPagination(Pageable pageable);
}

