
package com.examly.springapp.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.*;
import com.examly.springapp.repository.*;





@Service
public class JobPositionServiceImpl implements JobPositionService {

  private List<JobPosition> jobPositions = new ArrayList<>();
  private long counter = 1;

  @Autowired
  private JobPositionRepository jobPositionRepository;

  @Autowired
  private DepartmentRepository departmentRepository;

  public JobPosition addJobPosition(JobPosition jobPosition) {
    if (jobPosition.getDepartment() != null &&
      jobPosition.getDepartment().getDepartmentId() != null) {

      Department dept = departmentRepository
          .findById(jobPosition.getDepartment().getDepartmentId())
          .orElse(null);
      jobPosition.setDepartment(dept);
    }
    return jobPositionRepository.save(jobPosition);
  }

  public List<JobPosition> getAllJobPositions() {
    return jobPositionRepository.findAll();
  }

  public JobPosition getJobPositionById(Long id) {
    return jobPositionRepository.findById(id).orElse(null);
  }

  public JobPosition updateJobPosition(Long id, JobPosition jobPosition) {
    JobPosition existing = jobPositionRepository.findById(id).orElse(null);
    if (existing == null) return null;

    existing.setPositionTitle(jobPosition.getPositionTitle());
    existing.setDescription(jobPosition.getDescription());
    existing.setLocation(jobPosition.getLocation());
    existing.setExperienceRequired(jobPosition.getExperienceRequired());
    existing.setOpenings(jobPosition.getOpenings());
    return jobPositionRepository.save(existing);
  }

  @Override
public List<JobPosition> searchJobPositions(String keyword) {
  List<JobPosition> allJobs = jobPositionRepository.findAll();
  
  List<JobPosition> result = new ArrayList<>();
  String key = keyword.toLowerCase();

  for (JobPosition jp : allJobs) {
    if ((jp.getPositionTitle() != null && jp.getPositionTitle().toLowerCase().contains(key)) ||
      (jp.getDescription() != null && jp.getDescription().toLowerCase().contains(key))) {
      
      result.add(jp);
    }
  }
  return result;
}
}



