package com.examly.springapp.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.examly.springapp.model.JobPosition;

public interface JobPositionService {
  JobPosition createJobPosition(JobPosition jobPosition);
  List<JobPosition> getAllJobPositions();
  JobPosition getJobPositionById(Long id);
  JobPosition updateJobPosition(Long id, JobPosition jobPosition);
  void deleteJobPosition(Long id);
  Page<JobPosition> getJobPositionsWithPagination(Pageable pageable);
  List<JobPosition> searchJobPositions(String keyword);
}

