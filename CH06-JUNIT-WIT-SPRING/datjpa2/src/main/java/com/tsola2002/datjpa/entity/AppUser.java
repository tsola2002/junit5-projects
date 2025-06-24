package com.tsola2002.datjpa.entity;

public class AppUser {
  private String username;
  private String password;

  // Constructor, Getters, Setters

  public AppUser(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
