
package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.*;
import com.examly.springapp.repository.*;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private DepartmentRepository departmentRepository;

  public User addUser(User user) {
    if (user.getDepartment() != null && user.getDepartment().getDepartmentId() != null) {
      Department dept = departmentRepository
          .findById(user.getDepartment().getDepartmentId())
          .orElse(null);
      user.setDepartment(dept);
    }
    return userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public User updateUser(Long id, User user) {
    User existing = userRepository.findById(id).orElse(null);
    if (existing == null) return null;

    existing.setUsername(user.getUsername());
    existing.setEmail(user.getEmail());
    existing.setRole(user.getRole());
    existing.setPhoneNumber(user.getPhoneNumber());
    return userRepository.save(existing);
  }
}



