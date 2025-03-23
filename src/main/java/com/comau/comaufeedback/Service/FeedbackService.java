package com.comau.comaufeedback.Service;

import com.comau.comaufeedback.Entity.Feedback;
import com.comau.comaufeedback.Repo.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;
    public void saveFeedback(Feedback feedback){
        feedbackRepository.save(feedback);
    }
}

