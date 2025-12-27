package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.JobPositionRepository;

@Service
public class JobPositionServiceImpl implements JobPositionService {
  private final JobPositionRepository jobPositionRepository;

  public JobPositionServiceImpl(JobPositionRepository jobPositionRepository){
    this.jobPositionRepository = jobPositionRepository;
  }

  public JobPosition createJobPosition(JobPosition jobPosition){
    return jobPositionRepository.save(jobPosition);
  }

  public List<JobPosition> getAllJobPositions(){
    return jobPositionRepository.findAll();
  }

  public JobPosition getJobPositionById(Long id){
    return jobPositionRepository.findById(id).orElse(null);
  }

  public JobPosition updateJobPosition(Long id, JobPosition jobPosition){
    Optional<JobPosition> existing = jobPositionRepository.findById(id);
    if(existing.isPresent()){
      JobPosition existingPosition = existing.get();
      existingPosition.setPositionTitle(jobPosition.getPositionTitle());
      existingPosition.setDescription(jobPosition.getDescription());
      existingPosition.setLocation(jobPosition.getLocation());
      existingPosition.setExperienceRequired(jobPosition.getExperienceRequired());
      existingPosition.setOpenings(jobPosition.getOpenings());
      existingPosition.setDepartment(jobPosition.getDepartment());
      return jobPositionRepository.save(existingPosition);
    }
    return null;
  }

  public void deleteJobPosition(Long id){
    jobPositionRepository.deleteById(id);
  }

  public Page<JobPosition> getJobPositionsWithPagination(Pageable pageable){
    return jobPositionRepository.findAll(pageable);
  }

  public List<JobPosition> searchJobPositions(String keyword){
    return jobPositionRepository.findByPositionTitleContainingIgnoreCase(keyword);
  }
}

