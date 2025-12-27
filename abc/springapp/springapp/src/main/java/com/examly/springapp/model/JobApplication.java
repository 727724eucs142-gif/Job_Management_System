
package com.examly.springapp.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobApplication {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long applicationId;

  @Column
  private String coverLetter;
  private String resumeUrl;
  private String status;
  private String priority;

  @ManyToOne
  @JoinColumn(name = "candidate_id")
  private User candidate;

  @ManyToOne
  @JoinColumn(name = "position_id")
  private JobPosition jobPosition;

  public JobApplication() {}
  public JobApplication(String coverLetter, String resumeUrl, String status, String priority)
  {
    this.coverLetter = coverLetter;
    this.resumeUrl = resumeUrl;
    this.status = status;
    this.priority = priority;
  }

  public Long getApplicationId() { return applicationId; }
  public void setApplicationId(Long applicationId) { this.applicationId = applicationId; }

  public void setCoverLetter(String coverLetter) {this.coverLetter = coverLetter;}
  public String getCoverLetter() {return coverLetter;}

  public void setResumeUrl(String resumeUrl) {this.resumeUrl = resumeUrl;}
  public String getResumeUrl() {return resumeUrl;}

  public void setStatus(String status) {this.status = status;}
  public String getStatus() {return status;}

  public void setPriority(String priority) {this.priority = priority;}
  public String getPriority() {return priority;}

  public User getCandidate() { return candidate; }
  public void setCandidate(User candidate) { this.candidate = candidate; }

  public JobPosition getJobPosition() { return jobPosition; }
  public void setJobPosition(JobPosition jobPosition) { this.jobPosition = jobPosition; }

}


