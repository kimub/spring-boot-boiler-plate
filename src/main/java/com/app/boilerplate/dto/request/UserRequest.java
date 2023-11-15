package com.app.boilerplate.dto.request;

import lombok.Data;

@Data
public class UserRequest {
  String id;
  String email;
  String pw;
  String name;
}
