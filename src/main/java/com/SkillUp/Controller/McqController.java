package com.SkillUp.Controller;

import com.SkillUp.Repository.McqRepository;
import com.SkillUp.model.McqQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mcq")
public class McqController {

    @Autowired
    private McqRepository mcqRepository;

    // ✅ Add MCQ
    @PostMapping("/add")
    public McqQuestions addQuestion(@RequestBody McqQuestions mcqQuestion) {
        return mcqRepository.save(mcqQuestion);
    }

    // ✅ Get all MCQs
    @GetMapping("/all")
    public List<McqQuestions> getAllQuestions() {
        return mcqRepository.findAll();
    }

    // ✅ Get MCQ by ID
    @GetMapping("/{id}")
    public McqQuestions getQuestion(@PathVariable Long id) {
        return mcqRepository.findById(id).orElse(null);
    }

    // ✅ Delete MCQ
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        mcqRepository.deleteById(id);
        return "MCQ deleted successfully";
    }
}
