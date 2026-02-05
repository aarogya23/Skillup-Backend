package com.SkillUp.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TestResult {

    private int totalQuestions;
    private int correctCount;
    private int incorrectCount;

    private List<QuestionResult> correctQuestions;
    private List<QuestionResult> wrongQuestions;
}

