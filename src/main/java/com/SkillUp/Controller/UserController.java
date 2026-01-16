package com.SkillUp.Controller;

import com.SkillUp.Repository.UserRepository;
import com.SkillUp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // SAVE USER
    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/update/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User newUser) {

        User user = userRepository.findById(id).get(); // simple (no extra handling)

        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setGender(newUser.getGender());

        return userRepository.save(user);
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

}
