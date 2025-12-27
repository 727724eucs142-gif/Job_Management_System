
package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.JobPosition;

public interface JobPositionService {
  JobPosition addJobPosition(JobPosition jobPosition);
  List<JobPosition> getAllJobPositions();
  JobPosition getJobPositionById(Long id);
  JobPosition updateJobPosition(Long id, JobPosition jobPosition);
  List<JobPosition> searchJobPositions(String keyword);
}


