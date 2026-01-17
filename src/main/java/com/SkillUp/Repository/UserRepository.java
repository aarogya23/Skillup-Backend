package com.SkillUp.Repository;

import com.SkillUp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmailAndPassword(String email, String password);

    User findByNameAndPassword(String name, String password);
}
