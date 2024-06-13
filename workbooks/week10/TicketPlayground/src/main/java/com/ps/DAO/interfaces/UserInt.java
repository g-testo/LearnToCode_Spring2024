package com.ps.DAO.interfaces;

import com.ps.models.User;

import java.util.List;

public interface UserInt {
    List<User> getAllUsers();
    User getOneUser(int id);
    int createUser(User user);
    void updateUser(int id, User user);
    void deleteUser(int id);
}
