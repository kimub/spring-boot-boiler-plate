package com.app.boilerplate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String email;
  private String pw;
  private String name;

  public User(String email, String pw, String name) {
    this.email = email;
    this.pw = pw;
    this.name = name;
  }

  public void setUserInfo(String email, String pw, String name) {
    this.email = email;
    this.pw = pw;
    this.name = name;
  }
}
