package com.registration.course.clientapp.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dasboard")
public class HomeDasboardController {

  @GetMapping
  public String homeDasboard() {

    return "admin/index";
  }

}
