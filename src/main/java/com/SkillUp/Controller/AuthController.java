package com.SkillUp.Controller;

import com.SkillUp.Repository.UserRepository;
import com.SkillUp.dto.LoginRequest;
import com.SkillUp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        if (request.getEmailOrUsername() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body(
                    Map.of("message", "Email/Username and password are required")
            );
        }

        User user = userRepository.findByEmailOrName(
                request.getEmailOrUsername()
        );

        if (user == null) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("message", "Invalid username/email or password"));
        }

        // ⚠️ Plain password comparison (use BCrypt later)
        if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("message", "Invalid username/email or password"));
        }

        // Success
        return ResponseEntity.ok(user);
    }
}
