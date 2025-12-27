
package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.JobApplication;
import com.examly.springapp.service.JobApplicationService;
import java.util.List;

@RestController
@RequestMapping("/api/job-applications")


public class JobApplicationController {

  @Autowired
  private JobApplicationService jobApplicationService;

  @PostMapping
  public ResponseEntity<JobApplication> createJobApplication(@RequestBody JobApplication jobApplication) {
    JobApplication created = jobApplicationService.addJobApplication(jobApplication);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<JobApplication>> getAllJobApplications() {
    List<JobApplication> applications = jobApplicationService.getAllJobApplications();
    if (applications.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(applications);
  }

  @GetMapping(
    value = "/{id}",
    produces = MediaType.TEXT_PLAIN_VALUE
  )
  @ResponseBody
  public ResponseEntity<String> getJobApplicationById(@PathVariable Long id) {
    JobApplication application = jobApplicationService.getJobApplicationById(id);
    if (application == null) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Job application not found");
    }
    return ResponseEntity.ok("Job application found");
  }

  @PutMapping("/{id}")
  public ResponseEntity<JobApplication> updateJobApplication(@PathVariable Long id, @RequestBody JobApplication jobApplication) {
    JobApplication updated = jobApplicationService.updateJobApplication(id, jobApplication);
    if (updated == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteJobApplication(@PathVariable Long id) {
    JobApplication application = jobApplicationService.getJobApplicationById(id);
    if (application == null) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body("Job application not found");
    }
    return ResponseEntity.ok("Job application deleted");
  }
}

