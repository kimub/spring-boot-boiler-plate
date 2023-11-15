package com.app.boilerplate.controller;

import com.app.boilerplate.dto.request.UserRequest;
import com.app.boilerplate.dto.response.UserResponse;
import com.app.boilerplate.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping
  public List<UserResponse> getUsers() {
    return userService.getAllUser();
  }

  @GetMapping("/{id}")
  public UserResponse getUser(@PathVariable int id) {
    return userService.getUserById(id);
  }

  @PostMapping
  public void postUser(@RequestBody UserRequest userRequest) {
    userService.insertUser(userRequest);
  }

  @PutMapping("/{id}")
  public void updateUser(@PathVariable int id, @RequestBody UserRequest userRequest) {
    userService.updateUser(id, userRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable int id) {
    userService.deleteUser(id);
  }
}
