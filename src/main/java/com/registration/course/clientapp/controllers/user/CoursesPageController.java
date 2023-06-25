package com.registration.course.clientapp.controllers.user;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registration.course.clientapp.services.CourseService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/courses")
public class CoursesPageController {

  private CourseService courseService;

  @GetMapping
  public String getAllCourses(Model model, Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      model.addAttribute("auth", true);
      model.addAttribute("authentication", authentication);
      model.addAttribute("isROLE", authentication.getAuthorities().stream().findFirst().orElse(null).getAuthority());
    } else {
      model.addAttribute("auth", false);
      model.addAttribute("courses", courseService.getAll().getPayload());
    }
    return "user/courses/courses";
  }

  @GetMapping("/{id}")
  public String detailCourse(@PathVariable Integer id, Model model, Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      model.addAttribute("auth", true);
      model.addAttribute("authentication", authentication);
      model.addAttribute("isROLE", authentication.getAuthorities().stream().findFirst().orElse(null).getAuthority());
    } else {
      model.addAttribute("course", courseService.getById(id).getPayload().get(0));
      model.addAttribute("auth", false);
    }
    return "user/courses/course-details";
  }
}
