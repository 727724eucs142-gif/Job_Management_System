 package com.examly.springapp.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class InterviewFeedback {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long feedbackId;

  private String content;

  @JsonProperty("isInternal")
  private boolean isInternal;

  private String interviewRound;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "application_id", nullable = true)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidate", "jobPosition"})
  private JobApplication jobApplication;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = true)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "department"})
  private User user;

  public InterviewFeedback() {}

  public Long getFeedbackId() { return feedbackId; }
  public void setFeedbackId(Long feedbackId) { this.feedbackId = feedbackId; }

  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }

  public boolean getIsInternal() { return isInternal; }
  public void setIsInternal(boolean isInternal) { this.isInternal = isInternal; }

  public String getInterviewRound() { return interviewRound; }
  public void setInterviewRound(String interviewRound) { this.interviewRound = interviewRound; }

  public JobApplication getJobApplication() { return jobApplication; }
  public void setJobApplication(JobApplication jobApplication) { this.jobApplication = jobApplication; }

  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }
}
