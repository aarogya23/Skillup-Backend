package com.SkillUp.Repository;

import com.SkillUp.model.McqQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface McqRepository extends JpaRepository<McqQuestions, Long> {

    List<McqQuestions> findByCategory(String category);
}
