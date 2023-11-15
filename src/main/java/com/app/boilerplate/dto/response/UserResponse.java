package com.app.boilerplate.dto.response;

import lombok.Data;

@Data
public class UserResponse {
  Long id;
  String email;
  String pw;
  String name;
}
