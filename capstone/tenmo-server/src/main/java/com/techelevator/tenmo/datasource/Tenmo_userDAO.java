package com.techelevator.tenmo.datasource;

import com.techelevator.tenmo.usermanagement.model.User;

import java.util.List;

public interface Tenmo_userDAO {

    public List<Tenmo_user> getAllUsers();

    public Tenmo_user getUser(int id); // user by userID

    public Tenmo_user getUserByName(String username);

    public Tenmo_user getRole(String role);

    //public User alterPassword(String password);




}
