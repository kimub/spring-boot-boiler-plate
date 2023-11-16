package com.app.boilerplate.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
  Long id;
  String email;
  String pw;
  String name;
}
