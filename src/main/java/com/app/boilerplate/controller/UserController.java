package com.app.boilerplate.controller;

import com.app.boilerplate.common.CommonResponse;
import com.app.boilerplate.dto.request.UserRequest;
import com.app.boilerplate.dto.response.UserResponse;
import com.app.boilerplate.service.UserJPAService;
import com.app.boilerplate.service.UserMyBatisService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final UserJPAService userJPAService;
  private final UserMyBatisService userMyBatisService;

  public UserController(UserJPAService userJPAService, UserMyBatisService userMyBatisService) {
    this.userJPAService = userJPAService;
    this.userMyBatisService = userMyBatisService;
  }

  @GetMapping
  public ResponseEntity<CommonResponse<List<UserResponse>>> findUsers() {
//    return ResponseEntity.ok(userMyBatisService.getAllUser());

//    return ResponseEntity.status(HttpStatus.OK).body(userMyBatisService.getAllUser());

    return ResponseEntity.status(HttpStatus.OK).body(
        CommonResponse.<List<UserResponse>>builder().responseCode("-1").responseMessage("안녕하세요.")
            .data(userMyBatisService.findAllUser()).build());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommonResponse<UserResponse>> findUser(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(
        CommonResponse.<UserResponse>builder().responseCode("-2").responseMessage("안녕하세요.")
            .data(userMyBatisService.findUserById(id)).build());
  }

  @PostMapping
  public void saveUser(@RequestBody UserRequest userRequest) {
    userMyBatisService.saveUser(userRequest);
  }

  @PutMapping("/{id}")
  public void updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
    userMyBatisService.updateUser(id, userRequest);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userMyBatisService.deleteUser(id);
  }
}
