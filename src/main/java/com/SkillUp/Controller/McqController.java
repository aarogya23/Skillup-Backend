package com.SkillUp.Controller;


import com.SkillUp.model.McqQuestions;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/mcq")
public class McqController {

    private final List<McqQuestions> mcqList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    // Add MCQ
    @PostMapping("/add")
    public McqQuestions addMcq(@RequestBody McqQuestions mcq) {
        mcq.setId(counter.getAndIncrement());
        mcqList.add(mcq);
        return mcq;
    }

   
}
