
package com.examly.springapp.service;

import com.examly.springapp.model.InterviewFeedback;
import java.util.List;

public interface InterviewFeedbackService {
  InterviewFeedback addFeedback(InterviewFeedback feedback);
  List<InterviewFeedback> getAllFeedbacks();
  InterviewFeedback getFeedbackById(Long id);
  InterviewFeedback updateFeedback(Long id, InterviewFeedback feedback);
  List<InterviewFeedback> getFeedbacksByApplicationId(Long applicationId);
}

