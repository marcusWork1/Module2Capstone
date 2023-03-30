package com.techelevator.tenmo.datasource;

import com.techelevator.tenmo.usermanagement.model.User;

import java.util.List;

public interface Tenmo_userDAO {

    public List<User> getAllUsers();

    public User getUser(int id); // user by userID

    public User getUserByName(String username);

    public User getRole(String role);

    //public User alterPassword(String password);




}
