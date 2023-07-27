package com.registration.course.clientapp.controllers.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registration.course.clientapp.helpers.DailyViewCounter;
import com.registration.course.clientapp.services.CourseService;
import com.registration.course.clientapp.services.MemberService;
import com.registration.course.clientapp.services.TransactionService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/dasboard")
@PreAuthorize("hasRole('ADMIN')")
public class HomeDasboardController {

  private CourseService courseService;
  private MemberService memberService;
  private TransactionService transactionService;
  private final DailyViewCounter dailyViewCounter;

  @GetMapping
  public String homeDasboard(Model model) {
    model.addAttribute("home", true);
    model.addAttribute("membercount", memberService.getAll().getPayload().size() - 1);
    model.addAttribute("coursecount", courseService.getAll().getPayload().size());
    model.addAttribute("transactioncount", transactionService.getAll().getPayload().size());
    model.addAttribute("transactions", transactionService.getAll().getPayload().subList(0, 5));
    model.addAttribute("recentmembers", memberService.getAll().getPayload().subList(0, 3));
    model.addAttribute("dailyviews", dailyViewCounter.getCount());
    return "admin/index";
  }

}
