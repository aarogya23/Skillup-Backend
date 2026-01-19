package com.SkillUp.Repository;

import com.SkillUp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);

    User findByNameAndPassword(String name, String password);

    @Query("SELECT u FROM User u WHERE u.email = ?1 OR u.name = ?1")
    User findByEmailOrName(String value);
}
