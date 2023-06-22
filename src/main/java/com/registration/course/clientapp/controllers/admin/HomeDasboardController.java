package com.registration.course.clientapp.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeDasboardController {

  @GetMapping
  public String homeDasboard() {

    return "admin/index";
  }

}
