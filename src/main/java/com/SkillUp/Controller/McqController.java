package com.SkillUp.Controller;

import com.SkillUp.Repository.McqRepository;
import com.SkillUp.model.McqQuestions;
import com.SkillUp.model.TestResult;
import com.SkillUp.model.QuestionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/mcq")
public class McqController {

    @Autowired
    private McqRepository mcqRepository;

    // ---------------- CRUD APIs ----------------

    @PostMapping("/add")
    public McqQuestions addQuestion(@RequestBody McqQuestions mcqQuestion) {
        return mcqRepository.save(mcqQuestion);
    }

    @GetMapping("/all")
    public List<McqQuestions> getAllQuestions() {
        return mcqRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<McqQuestions> getByCategory(@PathVariable String category) {
        return mcqRepository.findByCategory(category);
    }

    @GetMapping("/{id}")
    public McqQuestions getQuestion(@PathVariable Long id) {
        return mcqRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        mcqRepository.deleteById(id);
        return "MCQ deleted successfully";
    }

    @PostMapping("/submit")
    public Map<String, Integer> submitTest(@RequestBody Map<Long, String> answers) {

        int correct = 0;

        for (Map.Entry<Long, String> entry : answers.entrySet()) {
            Long questionId = entry.getKey();
            String userAnswer = entry.getValue();

            McqQuestions question = mcqRepository.findById(questionId).orElse(null);
            if (question == null) continue;

            if (userAnswer.equalsIgnoreCase(question.getCorrectAnswer())) {
                correct++;
            }
        }

        int total = answers.size();
        int incorrect = total - correct;

        Map<String, Integer> result = new HashMap<>();
        result.put("total", total);
        result.put("correct", correct);
        result.put("incorrect", incorrect);

        return result;
    }


}
