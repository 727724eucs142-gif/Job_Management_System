 package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService service;

  @PostMapping
  public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
    Department saved = service.addDepartment(department);
    return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Department>> getAllDepartments() {
    return ResponseEntity.ok(service.getAllDepartments());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
    Department dept = service.getDepartmentById(id);
    if (dept == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(dept);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Department> updateDepartment(
      @PathVariable Long id,
      @RequestBody Department department) {

    Department updated = service.updateDepartment(id, department);
    if (updated == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(updated);
  }

  @GetMapping("/page/{page}/{size}")
  public ResponseEntity<Page<Department>> getDepartmentsByPage(
      @PathVariable int page,
      @PathVariable int size) {

    Page<Department> pageResult = service.getDepartmentsWithPagination(page, size);
    return ResponseEntity.ok(pageResult);
  }
}

