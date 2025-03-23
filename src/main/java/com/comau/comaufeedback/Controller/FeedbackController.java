package com.comau.comaufeedback.Controller;

import com.comau.comaufeedback.Entity.Feedback;
import com.comau.comaufeedback.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    @PostMapping
    public String saveFeedback(@RequestBody Feedback feedback)
    {
         feedbackService.saveFeedback(feedback);
          return "thanks";
    }
}
