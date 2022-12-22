package com.example.demo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Set;


@Entity
@Table
public class ApplicationUser implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  @NotNull @NotEmpty
  private String username;
  @NotNull @NotEmpty
  private String password;

  @Column(columnDefinition = "boolean default true")
  private boolean isAccountNonExpired;
  @Column(columnDefinition = "boolean default true")
  private boolean isAccountNonLocked;
  @Column(columnDefinition = "boolean default true")
  private boolean isCredentialsNonExpired;

  @Column(columnDefinition = "boolean default true")
  private boolean isEnabled;

  @Enumerated(EnumType.STRING)
  @Column(name = "application_user_role", nullable = false)
  private ApplicationUserRole applicationUserRole;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAccountNonExpired(boolean accountNonExpired) {
    isAccountNonExpired = accountNonExpired;
  }

  public void setAccountNonLocked(boolean accountNonLocked) {
    isAccountNonLocked = accountNonLocked;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    isCredentialsNonExpired = credentialsNonExpired;
  }

  public void setEnabled(boolean enabled) {
    isEnabled = enabled;
  }

  public ApplicationUserRole getApplicationUserRole() {
    return applicationUserRole;
  }

  public void setApplicationUserRole(ApplicationUserRole applicationUserRole) {
    this.applicationUserRole = applicationUserRole;
  }

  public ApplicationUser() {

  }

  @Override
  public Set<? extends GrantedAuthority> getAuthorities() {
    return applicationUserRole.getGrantedAuthorities();
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return isAccountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isAccountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isCredentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return isEnabled;
  }
}
