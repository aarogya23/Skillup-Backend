package com.SkillUp.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mcq_questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class McqQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    private String correctAnswer;
}
