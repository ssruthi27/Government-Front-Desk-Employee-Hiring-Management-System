package com.examly.springapp.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.examly.springapp.model.InterviewFeedback;

public interface InterviewFeedbackService {
  InterviewFeedback createInterviewFeedback(InterviewFeedback interviewFeedback);
  List<InterviewFeedback> getAllInterviewFeedbacks();
  InterviewFeedback getInterviewFeedbackById(Long id);
  InterviewFeedback updateInterviewFeedback(Long id, InterviewFeedback interviewFeedback);
  void deleteInterviewFeedback(Long id);
  Page<InterviewFeedback> getInterviewFeedbacksWithPagination(Pageable pageable);
  List<InterviewFeedback> getFeedbacksByJobApplication(Long jobApplicationId);
}

