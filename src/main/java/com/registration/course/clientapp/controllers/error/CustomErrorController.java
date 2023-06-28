package com.registration.course.clientapp.controllers.error;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CustomErrorController implements ErrorController {

  private static final String PATH = "/error";

  @RequestMapping(value = PATH)
  public String handleError(HttpServletRequest request) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    if (status != null) {
      int statusCode = Integer.parseInt(status.toString());
      if (statusCode == HttpStatus.FORBIDDEN.value()) {
        return "error/404"; // Nama file HTML 403 yang telah Anda buat
      } else if (statusCode == HttpStatus.UNAUTHORIZED.value()) {
        return "error/404"; // Nama file HTML 401 yang telah Anda buat
      }
    }
    return "error/404"; // Nama file HTML 404 yang telah Anda buat
  }

}
