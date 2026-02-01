package com.SkillUp.Controller;

import com.SkillUp.Repository.CourseRepository;
import com.SkillUp.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:5173/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    // 🔹 CREATE: Add / Enroll a course
    @PostMapping
    public ResponseEntity<Courses> addCourse(@RequestBody Courses course) {
        Courses savedCourse = courseRepository.save(course);
        return ResponseEntity.ok(savedCourse);
    }

    // 🔹 READ: Fetch all courses
    @GetMapping("/enrolled")
    public ResponseEntity<List<Courses>> getAllCourses() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    // 🔹 READ: Fetch course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Courses> getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 UPDATE: Edit full course details
    @PutMapping("/{id}")
    public ResponseEntity<Courses> updateCourse(
            @PathVariable Long id,
            @RequestBody Courses updatedCourse
    ) {
        Optional<Courses> existingCourseOpt = courseRepository.findById(id);

        if (existingCourseOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Courses existingCourse = existingCourseOpt.get();

        existingCourse.setTitle(updatedCourse.getTitle());
        existingCourse.setSubject(updatedCourse.getSubject());
        existingCourse.setLevel(updatedCourse.getLevel());
        existingCourse.setLanguage(updatedCourse.getLanguage());
        existingCourse.setInstructorName(updatedCourse.getInstructorName());
        existingCourse.setShortDescription(updatedCourse.getShortDescription());
        existingCourse.setFullDescription(updatedCourse.getFullDescription());
        existingCourse.setVideoUrls(updatedCourse.getVideoUrls());
        existingCourse.setWhatYouWillLearn(updatedCourse.getWhatYouWillLearn());
        existingCourse.setPrerequisites(updatedCourse.getPrerequisites());
        existingCourse.setDuration(updatedCourse.getDuration());
        existingCourse.setTotalLessons(updatedCourse.getTotalLessons());
        existingCourse.setBadge(updatedCourse.getBadge());
        existingCourse.setColor(updatedCourse.getColor());
        existingCourse.setIcon(updatedCourse.getIcon());
        existingCourse.setCertificate(updatedCourse.getCertificate());
        existingCourse.setLastUpdated(updatedCourse.getLastUpdated());

        Courses savedCourse = courseRepository.save(existingCourse);
        return ResponseEntity.ok(savedCourse);
    }

    // 🔹 PATCH: Update course progress only
    @PatchMapping("/{id}/progress")
    public ResponseEntity<Courses> updateProgress(
            @PathVariable Long id,
            @RequestParam int progress
    ) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setProgress(progress);
                    return ResponseEntity.ok(courseRepository.save(course));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 PATCH: Enable / Disable certificate
    @PatchMapping("/{id}/certificate")
    public ResponseEntity<Courses> updateCertificate(
            @PathVariable Long id,
            @RequestParam Boolean certificate
    ) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setCertificate(certificate);
                    return ResponseEntity.ok(courseRepository.save(course));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 DELETE: Remove course
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        if (!courseRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        courseRepository.deleteById(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}
