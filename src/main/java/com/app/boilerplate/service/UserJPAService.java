package com.app.boilerplate.service;

import com.app.boilerplate.entity.User;
import com.app.boilerplate.mapper.UserMapper;
import com.app.boilerplate.dto.request.UserRequest;
import com.app.boilerplate.dto.response.UserResponse;
import com.app.boilerplate.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserJPAService {
  private final UserRepository userRepository;

  public UserJPAService(UserMapper userMapper, UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public UserResponse getUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    return new UserResponse(user.getId(), user.getEmail(), user.getPw(), user.getName());
  }

  @Transactional
  public List<UserResponse> getAllUser() {
    List<User> userList = userRepository.findAll();

    return userList.stream().map(user -> new UserResponse(user.getId(), user.getEmail(),
        user.getPw(), user.getName())).collect(Collectors.toList());
  }

  @Transactional
  public void insertUser(UserRequest userRequest) {
    userRepository.save(new User(userRequest.getEmail(), userRequest.getPw(), userRequest.getName()));
  }

  @Transactional
  public void updateUser(Long id, UserRequest userRequest) {
    User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    user.setUserInfo(userRequest.getEmail(), userRequest.getPw(), userRequest.getName());
  }

  @Transactional
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

}
