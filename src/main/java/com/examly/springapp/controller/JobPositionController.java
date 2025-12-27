package com.examly.springapp.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.service.JobPositionService;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {
  private final JobPositionService jobPositionService;

  public JobPositionController(JobPositionService jobPositionService){
    this.jobPositionService = jobPositionService;
  }

  @PostMapping
  public ResponseEntity<JobPosition> createJobPosition(@RequestBody JobPosition jobPosition){
    JobPosition created = jobPositionService.createJobPosition(jobPosition);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }

  @GetMapping
  public ResponseEntity<List<JobPosition>> getAllJobPositions(){
    List<JobPosition> jobPositions = jobPositionService.getAllJobPositions();
    return ResponseEntity.ok(jobPositions);
  }

    @GetMapping("/paginated")
  public ResponseEntity<Page<JobPosition>> getJobPositionsWithPagination(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(defaultValue = "positionId") String sortBy){
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    Page<JobPosition> jobPositions = jobPositionService.getJobPositionsWithPagination(pageable);
    return ResponseEntity.ok(jobPositions);
  }

  @GetMapping("/search/{keyword}")
  public ResponseEntity<List<JobPosition>> searchJobPositions(@PathVariable String keyword){
    List<JobPosition> jobPositions = jobPositionService.searchJobPositions(keyword);
    return ResponseEntity.status(HttpStatus.OK).body(jobPositions);
  }

  @GetMapping("/{id}")
  public ResponseEntity<JobPosition> getJobPositionById(@PathVariable Long id){
    JobPosition jobPosition = jobPositionService.getJobPositionById(id);
    if(jobPosition != null){
      return ResponseEntity.ok(jobPosition);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<JobPosition> updateJobPosition(@PathVariable Long id, @RequestBody JobPosition jobPosition){
    JobPosition updated = jobPositionService.updateJobPosition(id, jobPosition);
    if(updated != null){
      return ResponseEntity.ok(updated);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteJobPosition(@PathVariable Long id){
    JobPosition existing = jobPositionService.getJobPositionById(id);
    if(existing == null){
      return ResponseEntity.notFound().build();
    }
    jobPositionService.deleteJobPosition(id);
    return ResponseEntity.noContent().build();
  }
}

