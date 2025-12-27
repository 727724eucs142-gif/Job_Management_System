 package com.examly.springapp.repository;

import com.examly.springapp.model.InterviewFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InterviewFeedbackRepository extends JpaRepository<InterviewFeedback, Long> {
  List<InterviewFeedback> findByJobApplicationApplicationId(Long applicationId);
}
