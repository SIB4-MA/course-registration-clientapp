package com.registration.course.clientapp.controllers.user.dasboard;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registration.course.clientapp.services.TransactionService;
import com.registration.course.clientapp.services.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/user/dasboard")
public class MemberDasboardPage {

  private TransactionService transactionService;
  private UserService userService;

  @GetMapping
  public String homeDasboardUser(Model model, Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      model.addAttribute("auth", true);
      model.addAttribute("authentication", authentication);
      model.addAttribute("isROLE",
          authentication.getAuthorities().stream().findFirst().orElse(null).getAuthority());
    } else {
      model.addAttribute("auth", false);
    }
    return "user/dasboard/index";
  }

  // @GetMapping
  // public String renderAllCourseByMemberId(Model model, Authentication
  // authentication){
  // if (authentication != null && authentication.isAuthenticated()) {
  // model.addAttribute("auth", true);
  // model.addAttribute("authentication", authentication);
  // model.addAttribute("isROLE",
  // authentication.getAuthorities().stream().findFirst().orElse(null).getAuthority());
  // } else {
  // model.addAttribute("auth", false);
  // }
  // return "user/courses/course-details";
  // }

  @GetMapping("/transaction")
  public String renderAllTransactionByMemberId(Model model, Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      model.addAttribute("auth", true);
      model.addAttribute("authentication", authentication);
      model.addAttribute("isROLE", authentication.getAuthorities().stream().findFirst().orElse(null).getAuthority());
      Integer memberId = userService.getByUsername(authentication.getPrincipal().toString()).getPayload().get(0)
          .getId();
      model.addAttribute("transactions",
          transactionService.getTransactionByMemberId(memberId).getPayload());
    } else {
      model.addAttribute("auth", false);
    }
    return "user/dasboard/transaction";
  }
}
