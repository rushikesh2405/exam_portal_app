package com.examportal.app.controller;

import com.examportal.app.model.Role;
import com.examportal.app.model.User;
import com.examportal.app.model.UserRole;
import com.examportal.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // create user
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) throws Exception{
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(48L);
        role.setRoleName("Normal");


        UserRole userRole = new UserRole();
        userRole.setUserId(user);
        userRole.setRoleId(role);

        roles.add(userRole);

        return this.userService.createUser(user,roles);
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String userName){
           return this.userService.getUser(userName);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }
}
