package com.SkillUp.Repository;

import com.SkillUp.model.McqQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface McqRepository extends JpaRepository<McqQuestions, Long> {
}
