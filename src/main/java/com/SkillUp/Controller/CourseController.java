package com.SkillUp.Controller;


import com.SkillUp.Repository.CourseRepository;
import com.SkillUp.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // 🔹 POST: Enroll / Add a course
    @PostMapping("/enroll")
    public ResponseEntity<Courses> enrollCourse(@RequestBody Courses course) {
        Courses savedCourse = courseRepository.save(course);
        return ResponseEntity.ok(savedCourse);
    }

    // 🔹 GET: Fetch all enrolled courses
    @GetMapping("/enrolled")
    public ResponseEntity<List<Courses>> getEnrolledCourses() {
        List<Courses> courses = courseRepository.findAll();
        return ResponseEntity.ok(courses);
    }

    // 🔹 GET: Fetch course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

