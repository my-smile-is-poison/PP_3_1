package com.example.springboot.project.servise;


import com.example.springboot.project.model.User;

import java.util.List;

public interface UserServise {
    List<User> getUsers();
    User showUserById(Long id);
    void saveUser(User user);
    void deleteUserById(Long id);
    void updateUserById(Long id, User user);
}
