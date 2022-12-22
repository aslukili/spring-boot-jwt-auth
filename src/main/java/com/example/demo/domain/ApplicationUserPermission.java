package com.example.demo.domain;

public enum ApplicationUserPermission {

  ORDER_READ("order:read"),
  ORDER_WRITE("order:write"),

  PRODUCT_READ("product:read"),
  PRODUCT_WRITE("product:write");


  private final String permission;

  ApplicationUserPermission(String permission) {
    this.permission = permission;
  }

  public String getPermission() {
    return permission;
  }
}
