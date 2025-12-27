

package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.service.JobPositionService;

@RestController
@RequestMapping("/api/job-positions")
public class JobPositionController {

  @Autowired
  private JobPositionService service;

  
   @PostMapping
  public ResponseEntity<JobPosition> addJobPosition(
      @RequestBody JobPosition jobPosition) {

    return new ResponseEntity<>(
        service.addJobPosition(jobPosition),
        HttpStatus.CREATED
    );
  }

  @GetMapping
  public ResponseEntity<List<JobPosition>> getAllJobPositions() {
    return ResponseEntity.ok(service.getAllJobPositions());
  }

  @GetMapping("/{id}")
  public ResponseEntity<JobPosition> getJobPositionById(
      @PathVariable Long id) {

    return ResponseEntity.ok(service.getJobPositionById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<JobPosition> updateJobPosition(
      @PathVariable Long id,
      @RequestBody JobPosition jobPosition) {

    return ResponseEntity.ok(
        service.updateJobPosition(id, jobPosition)
    );
  }

  @GetMapping("/search/{keyword}")
  public ResponseEntity<List<JobPosition>> searchJobPositions(
      @PathVariable String keyword) {

    return ResponseEntity.ok(
        service.searchJobPositions(keyword)
    );
  }
}



