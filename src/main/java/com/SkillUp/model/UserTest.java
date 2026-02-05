package com.SkillUp.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;   // or userId later
    private int totalQuestions;
    private int correctCount;
    private int incorrectCount;

    private LocalDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private HttpStatus.Series series;

    @OneToMany(mappedBy = "userTest", cascade = CascadeType.ALL)
    private List<UserAnswer> answers;
}
