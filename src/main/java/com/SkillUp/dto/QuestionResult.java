package com.SkillUp.dto;



import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionResult {
    private Long questionId;
    private String question;
    private String userAnswer;
    private String correctAnswer;
}
