package com.SkillUp.Controller;

import com.SkillUp.Repository.UserRepository;
import com.SkillUp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class loginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String loginUser(@RequestBody User loginData) {

        User user = null;

        // Login using email + password
        if (loginData.getEmail() != null) {
            user = userRepository.findByEmailAndPassword(

                    loginData.getEmail(),
                    loginData.getPassword()
            );
        }

        // Login using username + password
        else if (loginData.getName() != null) {
            user = userRepository.findByNameAndPassword(
                    loginData.getName(),
                    loginData.getPassword()
            );
        }

        // Return response
        if (user != null) {
            return "Your are successfully registered to the system.";
        } else {
            return "Invalid username/email or password";
        }
    }
}
