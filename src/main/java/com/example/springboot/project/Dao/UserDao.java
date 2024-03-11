package com.example.springboot.project.Dao;


import com.example.springboot.project.model.User;

import java.util.List;

public interface UserDao {
        List<User> getUsers();
        User showUserById(Long id);
        void saveUser(User user);
        void deleteUserById(Long id);
        void updateUserById(Long id, User user);

    }

