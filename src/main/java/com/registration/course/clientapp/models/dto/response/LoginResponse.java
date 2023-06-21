package com.registration.course.clientapp.models.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

  private String username;
  private String email;
  private List<String> authorities;

}