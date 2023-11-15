package com.app.boilerplate.service;

import com.app.boilerplate.mapper.UserMapper;
import com.app.boilerplate.dto.request.UserRequest;
import com.app.boilerplate.dto.response.UserResponse;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserMapper userMapper;

  public UserService(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public UserResponse getUserById(int id) {
    return userMapper.getUserById(id);
  }

  public List<UserResponse> getAllUser() {
    return userMapper.getAllUser();
  }

  public void insertUser(UserRequest userRequest) {
    userMapper.insertUser(userRequest);
  }

  public void updateUser(int id, UserRequest userRequest) {
    userMapper.updateUser(id, userRequest);
  }

  public void deleteUser(int id) {
    userMapper.deleteUser(id);
  }

}
