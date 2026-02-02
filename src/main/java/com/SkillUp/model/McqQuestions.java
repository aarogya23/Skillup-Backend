package com.SkillUp.model;



import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class McqQuestions {

    private Long id;
    private String question;
    private List<String> options;
    private int correctOptionIndex; // 0-based index
}
