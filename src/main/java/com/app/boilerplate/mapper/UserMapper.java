package com.app.boilerplate.mapper;

import com.app.boilerplate.dto.request.UserRequest;
import com.app.boilerplate.dto.response.UserResponse;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  UserResponse getUserById(int id);
  List<UserResponse> getAllUser();
  void insertUser(UserRequest userRequest);
  void updateUser(@Param("id") int id, @Param("userRequest") UserRequest userRequest);
  void deleteUser(int id);
}
