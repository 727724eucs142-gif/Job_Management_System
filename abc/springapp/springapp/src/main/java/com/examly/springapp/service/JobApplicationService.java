
package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.JobApplication;

public interface JobApplicationService {
  JobApplication addJobApplication(JobApplication jobApplication);
  List<JobApplication> getAllJobApplications();
  JobApplication getJobApplicationById(Long id);
  JobApplication updateJobApplication(Long id, JobApplication jobApplication);
}


