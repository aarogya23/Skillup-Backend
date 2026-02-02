package com.SkillUp.Controller;


import com.SkillUp.Repository.McqRepository;
import com.SkillUp.model.McqQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/mcq")
public class McqController {

    @Autowired
    private McqRepository mcqRepository;   // Auto injected repository

    @PostMapping("/add")
    public McqQuestions addMcq(@RequestBody McqQuestions mcq) {
        return mcqRepository.save(mcq);
    }

    @GetMapping("/all")
    public List<McqQuestions> getAllMcqs() {
        return mcqRepository.findAll();
    }

    @GetMapping("/{id}")
    public McqQuestions getMcqById(@PathVariable Long id) {
        Optional<McqQuestions> optional = mcqRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @PostMapping("/{id}/answer/{optionIndex}")
    public String submitAnswer(@PathVariable Long id, @PathVariable int optionIndex) {

        Optional<McqQuestions> optional = mcqRepository.findById(id);

        if (optional.isPresent()) {
            McqQuestions mcq = optional.get();

            if (mcq.getCorrectOptionIndex() == optionIndex) {
                return "Correct Answer";
            } else {
                return "Wrong Answer";
            }
        }

        return "Question Not Found";
    }
}
