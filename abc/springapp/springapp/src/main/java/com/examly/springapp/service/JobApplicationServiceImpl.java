
package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.*;
import com.examly.springapp.repository.*;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

  @Autowired
  private JobApplicationRepository jobApplicationRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JobPositionRepository jobPositionRepository;

  @Override
  public JobApplication addJobApplication(JobApplication jobApplication) {
    if (jobApplication.getCandidate() != null && jobApplication.getCandidate().getUserId() != null) {
      User candidate = userRepository.findById(jobApplication.getCandidate().getUserId()).orElse(null);
      jobApplication.setCandidate(candidate);
    }
    if (jobApplication.getJobPosition() != null && jobApplication.getJobPosition().getJobPositionId() != null) {
      JobPosition position = jobPositionRepository.findById(jobApplication.getJobPosition().getJobPositionId()).orElse(null);
      jobApplication.setJobPosition(position);
    }
    return jobApplicationRepository.save(jobApplication);
  }

  @Override
  public List<JobApplication> getAllJobApplications() {
    return jobApplicationRepository.findAll();
  }

  @Override
  public JobApplication getJobApplicationById(Long id) {
    return jobApplicationRepository.findById(id).orElse(null);
  }

  @Override
  public JobApplication updateJobApplication(Long id, JobApplication jobApplication) {
    JobApplication existing = jobApplicationRepository.findById(id).orElse(null);
    if (existing == null) return null;

    existing.setCoverLetter(jobApplication.getCoverLetter());
    existing.setResumeUrl(jobApplication.getResumeUrl());
    existing.setStatus(jobApplication.getStatus());
    existing.setPriority(jobApplication.getPriority());
    return jobApplicationRepository.save(existing);
  }
}


