package com.examly.springapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;

@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {
  private final InterviewFeedbackRepository interviewFeedbackRepository;

  public InterviewFeedbackServiceImpl(InterviewFeedbackRepository interviewFeedbackRepository){
    this.interviewFeedbackRepository = interviewFeedbackRepository;
  }

 public InterviewFeedback createInterviewFeedback(InterviewFeedback interviewFeedback){
    interviewFeedback.setFeedbackDate(LocalDateTime.now());
    return interviewFeedbackRepository.save(interviewFeedback);
}

  public List<InterviewFeedback> getAllInterviewFeedbacks(){
    return interviewFeedbackRepository.findAll();
  }

  public InterviewFeedback getInterviewFeedbackById(Long id){
    return interviewFeedbackRepository.findById(id).orElse(null);
  }

  public InterviewFeedback updateInterviewFeedback(Long id, InterviewFeedback interviewFeedback){
    Optional<InterviewFeedback> existing = interviewFeedbackRepository.findById(id);
    if(existing.isPresent()){
      InterviewFeedback existingFeedback = existing.get();
      existingFeedback.setContent(interviewFeedback.getContent());
      existingFeedback.setIsInternal(interviewFeedback.getIsInternal());
      existingFeedback.setInterviewRound(interviewFeedback.getInterviewRound());
      return interviewFeedbackRepository.save(existingFeedback);
    }
    return null;
  }

  public void deleteInterviewFeedback(Long id){
    interviewFeedbackRepository.deleteById(id);
  }

  public Page<InterviewFeedback> getInterviewFeedbacksWithPagination(Pageable pageable){
    return interviewFeedbackRepository.findAll(pageable);
  }

  public List<InterviewFeedback> getFeedbacksByJobApplication(Long jobApplicationId){
    return interviewFeedbackRepository.findByJobApplication_ApplicationId(jobApplicationId);
  }
}

