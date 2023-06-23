package com.registration.course.clientapp.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registration.course.clientapp.services.CourseService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/dasboard/course")
public class CourseDasboardController {

  private CourseService courseService;

  @GetMapping
  public String getAllCourses(Model model) {
    model.addAttribute("courses", courseService.getAll().getPayload());
    return "admin/course/course";
  }

  @GetMapping("/{id}")
  public String detailPage(@PathVariable Integer id, Model model) {

    model.addAttribute("course", courseService.getById(id).getPayload().get(0));
    return "admin/course/course-detail";
  }

  @GetMapping("/update/{id}")
  public String updatePage(@PathVariable Integer id, Model model) {

    model.addAttribute("course", courseService.getById(id).getPayload().get(0));
    return "admin/course/course-update";
  }

}