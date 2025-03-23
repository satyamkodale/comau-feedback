package com.comau.comaufeedback.Repo;

import com.comau.comaufeedback.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
