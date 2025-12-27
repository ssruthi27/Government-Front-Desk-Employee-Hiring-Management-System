package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.JobApplication;
import com.examly.springapp.repository.JobApplicationRepository;

@Service
public class JobApplicationServiceImpl implements JobApplicationService{
  private final JobApplicationRepository jobApplicationRepository;

  public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository){
    this.jobApplicationRepository=jobApplicationRepository;
  }
  
  public JobApplication getJobApplicationById(Long id){
    Optional<JobApplication> jobApplication = jobApplicationRepository.findById(id);
    return jobApplication.orElse(null);
  }

  public JobApplication createJobApplication(JobApplication jobApplication){
    return jobApplicationRepository.save(jobApplication);
  }

  public List<JobApplication> getAllJobApplications(){
    return jobApplicationRepository.findAll();
  }

  public JobApplication updateJobApplication(Long id, JobApplication jobApplication){
    Optional<JobApplication> existing = jobApplicationRepository.findById(id);
    if(existing.isPresent()){
      JobApplication existingApp = existing.get();
      existingApp.setCoverLetter(jobApplication.getCoverLetter());
      existingApp.setResumeUrl(jobApplication.getResumeUrl());
      existingApp.setStatus(jobApplication.getStatus());
      existingApp.setPriority(jobApplication.getPriority());
      existingApp.setApplicationDate(jobApplication.getApplicationDate());
      return jobApplicationRepository.save(existingApp);
    }
    return null;
  }

  public void deleteJobApplication(Long id){
    jobApplicationRepository.deleteById(id);
  }

  public Page<JobApplication> getJobApplicationsWithPagination(Pageable pageable){
    return jobApplicationRepository.findAll(pageable);
  }
}

