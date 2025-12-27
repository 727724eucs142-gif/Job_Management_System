
package com.examly.springapp.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobPosition {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("positionId")
  private Long jobPositionId;

  private String positionTitle;
  private String description;
  private String location;
  private String experienceRequired;
  private int openings;

  
  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;

  public Long getJobPositionId() {
    return jobPositionId;
  }

  public void setJobPositionId(Long jobPositionId) {
    this.jobPositionId = jobPositionId;
  }

  public String getPositionTitle() {
    return positionTitle;
  }

  public void setPositionTitle(String positionTitle) {
    this.positionTitle = positionTitle;
  }

  public String getDescription() {
    return description;
  }
 
  public void setDescription(String description) {
    this.description = description;
  }

  public String getLocation() {
    return location;
  }
 
  public void setLocation(String location) {
    this.location = location;
  }

  public String getExperienceRequired() {
    return experienceRequired;
  }
 
  public void setExperienceRequired(String experienceRequired) {
    this.experienceRequired = experienceRequired;
  }

  public int getOpenings() {
    return openings;
  }
 
  public void setOpenings(int openings) {
    this.openings = openings;
  }

  public Department getDepartment() {
    return department;
  }
 
  public void setDepartment(Department department) {
    this.department = department;
  }
}



