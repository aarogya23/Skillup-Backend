package com.SkillUp.model;


import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import javax.swing.text.html.Option;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private TypePatternQuestions.Question question;

    @ManyToOne
    @JoinColumn(name = "selected_option_id")
    private Option selectedOption;

    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "user_test_id")
    private UserTest userTest;
}
