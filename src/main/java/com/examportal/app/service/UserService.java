package com.examportal.app.service;

import com.examportal.app.model.User;
import com.examportal.app.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles);

    public User getUser(String userName);

    public void deleteUser(Long userId);

    public List<User> getAllUsers();

    public void updateUser(Long userId);
}
