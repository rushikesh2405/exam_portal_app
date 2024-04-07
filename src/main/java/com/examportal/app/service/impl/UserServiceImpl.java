package com.examportal.app.service.impl;

import com.examportal.app.model.User;
import com.examportal.app.model.UserRole;
import com.examportal.app.repo.RoleRepository;
import com.examportal.app.repo.UserRepository;
import com.examportal.app.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    //creating a user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
              for (UserRole ur : userRoles) {
                  roleRepository.save(ur.getRoleId());
              }
              user.getUserRoles().addAll(userRoles);
        return this.userRepository.save(user);
          }

    // getting a user
    @Override
    public User getUser(String userName) {
        return this.userRepository.findByUserName(userName);
    }

    // deleting a user
    @Override
    public void deleteUser(Long userId) {
            this.userRepository.deleteById(userId);
    }

    //getAllUsers
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    //update User by userId
    @Override
    public void updateUser(Long userId) {

    }

}
