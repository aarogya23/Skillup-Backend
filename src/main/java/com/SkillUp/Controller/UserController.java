package com.SkillUp.Controller;

import com.SkillUp.Repository.UserRepository;
import com.SkillUp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ================= SAVE USER (WITHOUT IMAGE) =================
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // ================= SAVE USER WITH PROFILE IMAGE =================
    @PostMapping("/save-with-image")
    public ResponseEntity<User> saveUserWithImage(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("gender") String gender,
            @RequestParam(value = "profileImage", required = false) MultipartFile profileImage
    ) throws IOException {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setGender(gender);

        if (profileImage != null && !profileImage.isEmpty()) {
            user.setProfileImage(profileImage.getBytes());
        }

        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }
}
