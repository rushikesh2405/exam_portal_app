package com.examportal.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
public class User {

       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private Long id;
       private String userName;
       private String password;
       private String firstName;
       private String profile;
       private String lastname;
       private String email;
       private String phone;
       private boolean enabled=true;

       public User() {

       }

       public Long getId() {
              return id;
       }

       public void setId(Long id) {
              this.id = id;
       }

       public User(Long id, String userName, String password, String firstName, String profile, String lastname, String email, String phone, boolean enabled) {
              this.id = id;
              this.userName = userName;
              this.password = password;
              this.firstName = firstName;
              this.profile = profile;
              this.lastname = lastname;
              this.email = email;
              this.phone = phone;
              this.enabled = enabled;
       }

       public String getUserName() {
              return userName;
       }

       public void setUserName(String userName) {
              this.userName = userName;
       }

       public String getPassword() {
              return password;
       }

       public void setPassword(String password) {
              this.password = password;
       }

       public String getFirstName() {
              return firstName;
       }

       public void setFirstName(String firstName) {
              this.firstName = firstName;
       }

       public String getProfile() {
              return profile;
       }

       public void setProfile(String profile) {
              this.profile = profile;
       }

       public String getLastname() {
              return lastname;
       }

       public void setLastname(String lastname) {
              this.lastname = lastname;
       }

       public String getEmail() {
              return email;
       }

       public void setEmail(String email) {
              this.email = email;
       }

       public String getPhone() {
              return phone;
       }

       public void setPhone(String phone) {
              this.phone = phone;
       }

       public boolean isEnabled() {
              return enabled;
       }

       public void setEnabled(boolean enabled) {
              this.enabled = enabled;
       }

       public Set<UserRole> getUserRoles() {
              return userRoles;
       }

       public void setUserRoles(Set<UserRole> userRoles) {
              this.userRoles = userRoles;
       }

       @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userId")
       @JsonIgnore
       private Set<UserRole> userRoles = new HashSet<>();


}
