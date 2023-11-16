package com.app.boilerplate.service;

import com.app.boilerplate.dto.request.UserRequest;
import com.app.boilerplate.dto.response.UserResponse;
import com.app.boilerplate.mapper.UserMapper;
import com.app.boilerplate.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserMyBatisService {
  private final UserMapper userMapper;

  public UserMyBatisService(UserMapper userMapper, UserRepository userRepository) {
    this.userMapper = userMapper;
  }

  public UserResponse getUserById(Long id) {
    return userMapper.getUserById(id);
  }

  public List<UserResponse> getAllUser() {
    return userMapper.getAllUser();
  }

  public void insertUser(UserRequest userRequest) {
    userMapper.insertUser(userRequest);
  }

  public void updateUser(Long id, UserRequest userRequest) {
    userMapper.updateUser(id, userRequest);
  }

  public void deleteUser(Long id) {
    userMapper.deleteUser(id);
  }

}
