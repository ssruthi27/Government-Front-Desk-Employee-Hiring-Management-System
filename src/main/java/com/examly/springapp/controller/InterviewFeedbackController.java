package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackService;

@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackController {
  private final InterviewFeedbackService interviewFeedbackService;

  public InterviewFeedbackController(InterviewFeedbackService interviewFeedbackService){
    this.interviewFeedbackService = interviewFeedbackService;
  }

  @PostMapping
  public ResponseEntity<InterviewFeedback> createInterviewFeedback(@RequestBody InterviewFeedback interviewFeedback){
    InterviewFeedback created = interviewFeedbackService.createInterviewFeedback(interviewFeedback);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }

  @GetMapping
  public ResponseEntity<List<InterviewFeedback>> getAllInterviewFeedbacks(){
    List<InterviewFeedback> feedbacks = interviewFeedbackService.getAllInterviewFeedbacks();
    return ResponseEntity.ok(feedbacks);
  }
  
    @GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getInterviewFeedbackById(@PathVariable Long id){
      InterviewFeedback feedback = interviewFeedbackService.getInterviewFeedbackById(id);
      if(feedback != null){
        return ResponseEntity.ok(feedback);
      }
      return ResponseEntity.notFound().build();
    }

    @GetMapping("/application/{applicationId}")
    public ResponseEntity<List<InterviewFeedback>> getFeedbacksByJobApplication(
        @PathVariable Long applicationId) {

    List<InterviewFeedback> feedbacks =
        interviewFeedbackService.getFeedbacksByJobApplication(applicationId);

    return ResponseEntity.ok(feedbacks);
}


  @PutMapping("/{id}")
  public ResponseEntity<InterviewFeedback> updateInterviewFeedback(@PathVariable Long id, @RequestBody InterviewFeedback interviewFeedback){
    InterviewFeedback updated = interviewFeedbackService.updateInterviewFeedback(id, interviewFeedback);
    if(updated != null){
      return ResponseEntity.ok(updated);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteInterviewFeedback(@PathVariable Long id){
    InterviewFeedback existing = interviewFeedbackService.getInterviewFeedbackById(id);
    if(existing == null){
      return ResponseEntity.notFound().build();
    }
    interviewFeedbackService.deleteInterviewFeedback(id);
    return ResponseEntity.noContent().build();
  }
}


