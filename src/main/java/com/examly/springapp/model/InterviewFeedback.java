package com.examly.springapp.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InterviewFeedback {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long feedbackId;

  private String content;
  private Boolean isInternal;
  private String interviewRound;
  private LocalDateTime feedbackDate;

  @ManyToOne
  @JoinColumn(name = "job_application_id", referencedColumnName = "applicationId")
  private JobApplication jobApplication;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName= "user_id")
  private User user;

  public InterviewFeedback() {
  }

  public InterviewFeedback( String content, Boolean isInternal, String interviewRound,
      LocalDateTime feedbackDate, JobApplication jobApplication, User user) {
    this.content = content;
    this.isInternal = isInternal;
    this.interviewRound = interviewRound;
    this.feedbackDate = feedbackDate;
    this.jobApplication = jobApplication;
    this.user = user;
  }

  public Long getFeedbackId() {
    return feedbackId;
  }

  public void setFeedbackId(Long feedbackId) {
    this.feedbackId = feedbackId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Boolean getIsInternal() {
    return isInternal;
  }

  public void setIsInternal(Boolean isInternal) {
    this.isInternal = isInternal;
  }

  public String getInterviewRound() {
    return interviewRound;
  }

  public void setInterviewRound(String interviewRound) {
    this.interviewRound = interviewRound;
  }

  public LocalDateTime getFeedbackDate() {
    return feedbackDate;
  }

  public void setFeedbackDate(LocalDateTime feedbackDate) {
    this.feedbackDate = feedbackDate;
  }

  public JobApplication getJobApplication() {
    return jobApplication;
  }

  public void setJobApplication(JobApplication jobApplication) {
    this.jobApplication = jobApplication;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}

